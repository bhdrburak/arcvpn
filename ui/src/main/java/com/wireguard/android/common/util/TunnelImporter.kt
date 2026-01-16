/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.util

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.wireguard.android.Application
import com.wireguard.android.R
import com.wireguard.android.presentation.tunnel.ConfigNamingDialogFragment
import com.wireguard.android.model.ObservableTunnel
import com.wireguard.android.data.remote.LoginResponse
import com.wireguard.config.Config
import com.wireguard.config.Interface
import com.wireguard.config.Peer
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object TunnelImporter {

    suspend fun importTunnelFromLoginResponse(loginResponse: LoginResponse, messageCallback: (CharSequence) -> Unit) = withContext(Dispatchers.IO) {
        val context = Application.get().applicationContext
        val futureTunnels = ArrayList<Deferred<ObservableTunnel>>()
        val throwables = ArrayList<Throwable>()
        val name = loginResponse.DeviceName

        val builder = Config.Builder()

        val interfaceBuilder = Interface.Builder()
        interfaceBuilder.parseAddresses(loginResponse.IPsStr)
        interfaceBuilder.parsePrivateKey(loginResponse.PrivateKey)
        interfaceBuilder.parseDnsServers(loginResponse.DNSStr)
        interfaceBuilder.setMtu(loginResponse.Mtu)
//        interfaceBuilder.includeApplications()
//        interfaceBuilder.excludeApplications()

        val peerBuilder = Peer.Builder()
        peerBuilder.parseEndpoint(loginResponse.Endpoint)
        peerBuilder.parsePublicKey("qwR6yP/KREpuJjxp8ywrDrYePHdkvjmQMKME6u+xf0k=")
//        peerBuilder.parsePublicKey(loginResponse.PublicKey)
//        peerBuilder.parseAllowedIPs("0.0.0.0/0, ::/0")
        peerBuilder.parseAllowedIPs(loginResponse.AllowedIPsStr)
        peerBuilder.setPersistentKeepalive(loginResponse.PersistentKeepalive)
        peerBuilder.parsePreSharedKey(loginResponse.PresharedKey)

        builder.setInterface(interfaceBuilder.build())
        builder.addPeer(peerBuilder.build())


//        while (reader.readLine().also { line = it } != null) {
//            val commentIndex = line!!.indexOf('#')
//            if (commentIndex != -1) line = line!!.substring(0, commentIndex)
//            line = line!!.trim { it <= ' ' }
//            if (line!!.isEmpty()) continue
//            if (line!!.startsWith("[")) {
//                // Consume all [Peer] lines read so far.
//                if (inPeerSection) {
//                    builder.parsePeer(peerLines)
//                    peerLines.clear()
//                }
//                if ("[Interface]".equals(line, ignoreCase = true)) {
//                    inInterfaceSection = true
//                    inPeerSection = false
//                    seenInterfaceSection = true
//                } else if ("[Peer]".equals(line, ignoreCase = true)) {
//                    inInterfaceSection = false
//                    inPeerSection = true
//                } else {
//                    throw BadConfigException(
//                        BadConfigException.Section.CONFIG, BadConfigException.Location.TOP_LEVEL,
//                        BadConfigException.Reason.UNKNOWN_SECTION, line
//                    )
//                }
//            } else if (inInterfaceSection) {
//                interfaceLines.add(line!!)
//            } else if (inPeerSection) {
//                peerLines.add(line!!)
//            } else {
//                throw BadConfigException(
//                    BadConfigException.Section.CONFIG, BadConfigException.Location.TOP_LEVEL,
//                    BadConfigException.Reason.UNKNOWN_SECTION, line
//                )
//            }
//        }
//        if (inPeerSection) builder.parsePeer(peerLines)
//        if (!seenInterfaceSection) throw BadConfigException(
//            BadConfigException.Section.CONFIG, BadConfigException.Location.TOP_LEVEL,
//            BadConfigException.Reason.MISSING_SECTION, null
//        )
//        // Combine all [Interface] sections in the file.
//        // Combine all [Interface] sections in the file.
//        builder.parseInterface(interfaceLines)

        val config = builder.build()

        futureTunnels.add(async(SupervisorJob()) { Application.getTunnelManager().create(name, config) })

        if (futureTunnels.isEmpty()) {
            if (throwables.size == 1) {
                throw throwables[0]
            } else {
                require(throwables.isNotEmpty()) { context.getString(R.string.no_configs_error) }
            }
        }
        val tunnels = futureTunnels.mapNotNull {
            try {
                it.await()
            } catch (e: Throwable) {
                throwables.add(e)
                null
            }
        }
        withContext(Dispatchers.Main.immediate) { onTunnelImportFinished(tunnels, throwables, messageCallback) }
    }

    suspend fun importTunnelFromRaw(messageCallback: (CharSequence) -> Unit) = withContext(Dispatchers.IO) {
        val context = Application.get().applicationContext

        val inputStream: InputStream = context.resources.openRawResource(
            context.resources.getIdentifier(
                "innovpn",
                "raw", context.packageName
            )
        )

        importTunnelFromRaw(inputStream, messageCallback)
    }


    suspend fun importTunnelFromRaw(inputStream: InputStream, messageCallback: (CharSequence) -> Unit) = withContext(Dispatchers.IO) {
        val context = Application.get().applicationContext
        val futureTunnels = ArrayList<Deferred<ObservableTunnel>>()
        val throwables = ArrayList<Throwable>()
        val name = "ArcVpn"

        val baos = ByteArrayOutputStream()


        val buffer = ByteArray(1024)
        var len: Int
        while (inputStream.read(buffer).also { len = it } > -1) {
            baos.write(buffer, 0, len)
        }
        baos.flush()

        val is1: InputStream = ByteArrayInputStream(baos.toByteArray())
        val is2: InputStream = ByteArrayInputStream(baos.toByteArray())

        var privateKey = ""
        val reader = BufferedReader(InputStreamReader(is1))
        reader.lines().forEach { line ->
            val commentIndex: Int = line.indexOf('#')
            if (line.contains("PrivateKey = ")) {
                privateKey = line.replace("PrivateKey = ", "")
            }
            if (commentIndex != -1) {
                val usernameIndex: Int = line.indexOf("# WireGuard configuration: ")
                if (usernameIndex != -1) {
                    val username: String = line.substring(usernameIndex + 27, line.length)
                    Application.getCacheManager().write("username", username)
                    return@forEach
                }
            }
        }

        if(privateKey != ""){

            Application.getCacheManager().writeString("privateKey", privateKey)
        }


        futureTunnels.add(async(SupervisorJob()) { Application.getTunnelManager().create(name, Config.parse(is2)) })

        if (futureTunnels.isEmpty()) {
            if (throwables.size == 1) {
                throw throwables[0]
            } else {
                require(throwables.isNotEmpty()) { context.getString(R.string.no_configs_error) }
            }
        }
        val tunnels = futureTunnels.mapNotNull {
            try {
                it.await()
            } catch (e: Throwable) {
                throwables.add(e)
                null
            }
        }
        withContext(Dispatchers.Main.immediate) { onTunnelImportFinished(tunnels, throwables, messageCallback) }
    }

    suspend fun importTunnel(contentResolver: ContentResolver, uri: Uri, messageCallback: (CharSequence) -> Unit) = withContext(Dispatchers.IO) {
        val context = Application.get().applicationContext
        val futureTunnels = ArrayList<Deferred<ObservableTunnel>>()
        val throwables = ArrayList<Throwable>()
        try {
            val columns = arrayOf(OpenableColumns.DISPLAY_NAME)
            var name = ""
            contentResolver.query(uri, columns, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst() && !cursor.isNull(0)) {
                    name = cursor.getString(0)
                }
            }
            if (name.isEmpty()) {
                name = Uri.decode(uri.lastPathSegment)
            }
            var idx = name.lastIndexOf('/')
            if (idx >= 0) {
                require(idx < name.length - 1) { context.getString(R.string.illegal_filename_error, name) }
                name = name.substring(idx + 1)
            }
            val isZip = name.lowercase().endsWith(".zip")
            if (name.lowercase().endsWith(".conf")) {
                name = name.substring(0, name.length - ".conf".length)
            } else {
                require(isZip) { context.getString(R.string.bad_extension_error) }
            }

            if (isZip) {
                ZipInputStream(contentResolver.openInputStream(uri)).use { zip ->
                    val reader = BufferedReader(InputStreamReader(zip, StandardCharsets.UTF_8))
                    var entry: ZipEntry?
                    while (true) {
                        entry = zip.nextEntry ?: break
                        name = entry.name
                        idx = name.lastIndexOf('/')
                        if (idx >= 0) {
                            if (idx >= name.length - 1) {
                                continue
                            }
                            name = name.substring(name.lastIndexOf('/') + 1)
                        }
                        if (name.lowercase().endsWith(".conf")) {
                            name = name.substring(0, name.length - ".conf".length)
                        } else {
                            continue
                        }
                        try {
                            Config.parse(reader)
                        } catch (e: Throwable) {
                            throwables.add(e)
                            null
                        }?.let {
                            val nameCopy = name
                            futureTunnels.add(async(SupervisorJob()) { Application.getTunnelManager().create(nameCopy, it) })
                        }
                    }
                }
            } else {
                futureTunnels.add(async(SupervisorJob()) { Application.getTunnelManager().create(name, Config.parse(contentResolver.openInputStream(uri)!!)) })
            }

            if (futureTunnels.isEmpty()) {
                if (throwables.size == 1) {
                    throw throwables[0]
                } else {
                    require(throwables.isNotEmpty()) { context.getString(R.string.no_configs_error) }
                }
            }
            val tunnels = futureTunnels.mapNotNull {
                try {
                    it.await()
                } catch (e: Throwable) {
                    throwables.add(e)
                    null
                }
            }
            withContext(Dispatchers.Main.immediate) { onTunnelImportFinished(tunnels, throwables, messageCallback) }
        } catch (e: Throwable) {
            withContext(Dispatchers.Main.immediate) { onTunnelImportFinished(emptyList(), listOf(e), messageCallback) }
        }
    }

    fun importTunnel(parentFragmentManager: FragmentManager, configText: String, messageCallback: (CharSequence) -> Unit) {
        try {
            // Ensure the config text is parseable before proceeding…
            Config.parse(ByteArrayInputStream(configText.toByteArray(StandardCharsets.UTF_8)))

            // Config text is valid, now create the tunnel…
            ConfigNamingDialogFragment.newInstance(configText).show(parentFragmentManager, null)
        } catch (e: Throwable) {
            onTunnelImportFinished(emptyList(), listOf<Throwable>(e), messageCallback)
        }
    }

    private fun onTunnelImportFinished(tunnels: List<ObservableTunnel>, throwables: Collection<Throwable>, messageCallback: (CharSequence) -> Unit) {
        val context = Application.get().applicationContext
        var message = ""
        for (throwable in throwables) {
            val error = ErrorMessages[throwable]
            message = context.getString(R.string.import_error, error)
            Log.e(TAG, message, throwable)
        }
        if (tunnels.size == 1 && throwables.isEmpty())
            message = context.getString(R.string.import_success, tunnels[0].name)
        else if (tunnels.isEmpty() && throwables.size == 1)
        else if (throwables.isEmpty())
            message = context.resources.getQuantityString(
                R.plurals.import_total_success,
                tunnels.size, tunnels.size
            )
        else if (!throwables.isEmpty())
            message = context.resources.getQuantityString(
                R.plurals.import_partial_success,
                tunnels.size + throwables.size,
                tunnels.size, tunnels.size + throwables.size
            )

        messageCallback(message)
    }

    private const val TAG = "WireGuard/TunnelImporter"
}