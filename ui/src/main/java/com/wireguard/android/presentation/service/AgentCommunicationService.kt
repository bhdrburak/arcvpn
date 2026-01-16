/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.service

import android.app.ActivityManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import androidx.core.content.ContextCompat
import com.wireguard.android.Application
import com.wireguard.android.common.knobs.DEFAULT_ALWAYS_ON_CONNECTION
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.HttpUrl.Companion.toHttpUrl

class AgentCommunicationService : Service() {

    private var compositeDisposable: CompositeDisposable? = null

    private val vpnConfigurationReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val port = intent.extras?.getString("com.mobileitm.mdm.PORT")
            val host = intent.extras?.getString("com.mobileitm.mdm.HOST")
            val name = intent.extras?.getString("com.mobileitm.mdm.NAME")
            val connectionTime = intent.extras?.getString("com.mobileitm.mdm.CONNECTION_TIME")
            val allowedPackages = intent.extras?.getStringArrayList("com.mobileitm.mdm.ALLOWED_APPLICATION")
            val alwaysOn = intent.extras?.getBoolean("com.mobileitm.mdm.ALWAYS_ON")

            if (host!!.isNotEmpty()) {
                try {
                    host.toHttpUrl()
                } catch (e: Exception) {
                    return
                }
            } else {
                val tunnelManager = Application.getTunnelManager()

                Application.getCacheManager().writeString("is_logged_in", "false")
                CoroutineScope(Dispatchers.Default).launch {
                    tunnelManager.getTunnels().forEach { tunnel ->
                        tunnelManager.delete(tunnel)
                    }
                }
            }

            val allowedPackagesString = allowedPackages.toString().replace("[", "").replace("]", "").replace(":", ",").replace(" ", "")

            val cacheManager = Application.getCacheManager()
            cacheManager.writeString("port", port.toString())
            cacheManager.writeString("connection_name", name ?: "")
            cacheManager.writeString("host", host)
            cacheManager.writeString("allowed_app_packages", allowedPackagesString)
            cacheManager.writeString("connection_time", connectionTime.toString())
            cacheManager.writeBoolean("always_on_connection", alwaysOn ?: DEFAULT_ALWAYS_ON_CONNECTION)
            cacheManager.writeBoolean("manage_config_changed", true)


            /**
             * adb shell am broadcast -a com.mobileitm.mdm.VPNCONFIGURATION --ei com.mobileitm.mdm.PORT 443 --es com.mobileitm.mdm.HOST "https://mvpn.mobileitm.com" --es com.mobileitm.mdm.NAME "asdwqe" --ez com.mobileitm.mdm.ALWAYS_ON false
             */

            if (Application.getCacheManager().readString("is_logged_in", "true") == "true") {
                //stopService()

                if (compositeDisposable == null) {
                    compositeDisposable = CompositeDisposable()
                }

                CoroutineScope(Dispatchers.Main).launch {
                    if (isServiceRunning(context, VpnSyncService::class.java)){
                        stopService(Intent(context, VpnSyncService::class.java))
                    }
                    startService(true)
                }
            }
        }
    }


    fun isServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
        val manager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager?
        for (service in manager!!.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.getName() == service.service.className) {
                return true
            }
        }
        return false
    }

    fun stringToWords(s: String) = s.trim().splitToSequence(' ')
        .filter { it.isNotEmpty() } // or: .filter { it.isNotBlank() }
        .toList()

    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter("com.mobileitm.mdm.VPNCONFIGURATION")

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.registerReceiver(this, vpnConfigurationReceiver, intentFilter, ContextCompat.RECEIVER_EXPORTED)
        } else {
            registerReceiver(vpnConfigurationReceiver, intentFilter)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
        compositeDisposable?.dispose()
        compositeDisposable = null
        unregisterReceiver(vpnConfigurationReceiver)
    }

    private fun stopService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intent = Intent(this, VpnSyncService::class.java) // Build the intent for the service
            intent.action = VpnSyncService.ACTION_STOP
            startService(intent)
        }
    }

    private fun startService(willReset: Boolean = false) {
        val intent = Intent(this, VpnSyncService::class.java)
        if (willReset) intent.action = VpnSyncService.ACTION_RESET

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
    }
}