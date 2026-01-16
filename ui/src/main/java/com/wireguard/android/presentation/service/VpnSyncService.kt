/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.wireguard.android.Application
import com.wireguard.android.R
import com.wireguard.android.activity.HomeActivity
import com.wireguard.android.backend.Tunnel
import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.model.ObservableTunnel
import com.wireguard.android.common.knobs.AdminKnobs
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.common.session.SessionManager
import com.wireguard.android.domain.usecase.get_config.GetConfigUseCase
import com.wireguard.android.domain.usecase.refresh_token.RefreshTokenUseCase
import com.wireguard.android.common.util.TunnelImporter
import com.wireguard.android.viewmodel.ConfigProxy
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject


/**
 * Created by Fatih Atasever on 10.06.2024.
 */

private const val CHANNEL_ID = "VPN Service Channel"
var PING_INTERVAL = 60000L
private const val TAG = "VpnSyncService"
@AndroidEntryPoint
class VpnSyncService : Service() {

    @Inject
    lateinit var refreshTokenUseCase: RefreshTokenUseCase

    @Inject
    lateinit var fetchConfigUseCase: GetConfigUseCase

    private var restrictionsReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val cacheManager = Application.getCacheManager()
            cacheManager.writeBoolean("manage_config_changed", true)
            ProfileManager.updateFromRestrictions()
            fetchNewConfig()
        }
    }


    private val job = SupervisorJob()
    private var scope = CoroutineScope(Dispatchers.IO + job)

    override fun onCreate() {
        super.onCreate()
        Log.e(TAG, "onCreate")


        val restrictionsFilter = IntentFilter(Intent.ACTION_APPLICATION_RESTRICTIONS_CHANGED)
        //val connectionTime = cacheManager.readString("connection_time", "60")
        val connectionTime = AdminKnobs.connectionTime


        ContextCompat.registerReceiver(this, restrictionsReceiver, restrictionsFilter, ContextCompat.RECEIVER_NOT_EXPORTED)

        Log.e("VpnSyncService"," AdminKnobs ConnectionTime: ${AdminKnobs.connectionTime}")
        Log.e("VpnSyncService"," CacheMaanager ConnectionTime: $connectionTime")
        Log.e("VpnSyncService"," AdminKnobs Host: ${AdminKnobs.host}")
        Log.e("VpnSyncService"," AdminKnobs Port: ${AdminKnobs.port}")
        Log.e("VpnSyncService"," AdminKnobs Name: ${AdminKnobs.connectionName}")
        Log.e("VpnSyncService"," AdminKnobs Always Connection: ${AdminKnobs.alwaysOnConnection}")
        Log.e("VpnSyncService"," AdminKnobs  Packages: ${AdminKnobs.getAllowedPackageList().toString()}")




        if (connectionTime != "null") {
            connectionTime.let {
                PING_INTERVAL = it.toLong() * 1000
            }
        }

        createNotificationChannel()
        startForeground(1, getNotification())
    }


    /*

override fun onDestroy() {
    super.onDestroy()
    Log.e(TAG, "onDestroy")
    compositeDisposable?.clear()
    compositeDisposable?.dispose()
    compositeDisposable = null


}

override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
    Log.e(TAG, "onStartCommand: ${intent?.action}")

    createNotificationChannel()
    startForeground(1, getNotification())

    if (intent?.action == ACTION_STOP) {
        stopService()
        return START_NOT_STICKY
    } else {
        scope = CoroutineScope(Dispatchers.IO + job)
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.clear()
        checkVpnDelayed(intent?.action == ACTION_RESET)
        return START_STICKY
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun checkVpnDelayed(willReset: Boolean = false) {
    Log.e(TAG, "checkVpnDelayed: willReset=$willReset")
    compositeDisposable?.add(
        Completable.timer(
            if (willReset) 2000L else PING_INTERVAL,
            TimeUnit.MILLISECONDS,
            AndroidSchedulers.mainThread()
        ).andThen(Completable
            .create { emitter ->
                runBlocking { checkVPNConnection(willReset) }
                emitter.onComplete()
            }
        ).subscribe()
    )
}

private suspend fun checkVPNConnection(willReset: Boolean) {
    Log.e(TAG, "checkVPNConnection: willReset=$willReset")
    try {
        scope.launch {

            fetchNewConfig()

        }
    } catch (e: Exception) {
        Log.e(TAG, "Error updating stats", e)
    }
}
*/
    private fun checkVpnDelayed(willReset: Boolean = false) {
        Log.d(TAG, "checkVpnDelayed method")

        val delayMillis = if (willReset) 2000L else PING_INTERVAL
        scope.launch {
            delay(delayMillis)
            checkVPNConnection(willReset)
        }
    }

    private  fun checkVPNConnection(willReset: Boolean) {
        Log.d(TAG, "checkVPNConnection: willReset=$willReset")
        try {
            fetchNewConfig()
        } catch (e: Exception) {
            Log.e(TAG, "Error updating stats", e)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ${intent?.action}")

        createNotificationChannel()
        startForeground(1, getNotification())

        if (intent?.action == ACTION_STOP) {
            stopService()
            return START_NOT_STICKY
        } else {
            scope = CoroutineScope(Dispatchers.IO + job)
            checkVpnDelayed(intent?.action == ACTION_RESET)
            //imitateConfigChangeDelayed()
            return START_STICKY
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy")
        job.cancel() // scope'u iptal eder
        unregisterReceiver(restrictionsReceiver)
    }

    private fun checkPrivateKey(inputStream: InputStream): Boolean {
        val context = Application.get().applicationContext
        val futureTunnels = ArrayList<Deferred<ObservableTunnel>>()
        val throwables = ArrayList<Throwable>()
        val name = "MobileItmVpn"

        var privateKey = ""
        val baos = ByteArrayOutputStream()


        val buffer = ByteArray(1024)
        var len: Int
        while (inputStream.read(buffer).also { len = it } > -1) {
            baos.write(buffer, 0, len)
        }
        baos.flush()

        val is1: InputStream = ByteArrayInputStream(baos.toByteArray())
        val is2: InputStream = ByteArrayInputStream(baos.toByteArray())

        val reader = BufferedReader(InputStreamReader(is1))
        reader.lines().forEach { line ->
            if (line.contains("PrivateKey = ")) {
                privateKey = line.replace("PrivateKey = ", "")
                return@forEach
            }
        }
        val oldPrivateKey = Application.getCacheManager().readString("privateKey", "")
        Log.d(TAG, "oldPrivate : $oldPrivateKey")
        Log.d(TAG, "newPrivate : $privateKey")
        return if (oldPrivateKey != privateKey) {

            Application.getCacheManager().writeString("privateKey", privateKey)
            return false
        } else {
            return true
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private suspend fun connectToTunnel(tunnel: ObservableTunnel, forceReset: Boolean) {
        Log.e(TAG, "connectToTunnel")

        val cacheManager = Application.getCacheManager()
        cacheManager.writeBoolean("manage_config_changed", false)

        cacheManager.writeBoolean("last_state", true)
        if (forceReset) {
            Application.getTunnelManager().setTunnelState(tunnel, Tunnel.State.DOWN)
        }

        scope.launch {
            tunnel.config?.also { safeConfig ->
                val config = ConfigProxy(safeConfig)

                // TODO update always on, ip, port, connection name

                AdminKnobs.getAllowedPackageList().also { stepPackageList ->
                    Log.e(TAG, "allowed packages: $stepPackageList")
                    if (stepPackageList.isNotEmpty()) {

                        config.`interface`.excludedApplications.clear()
                        config.`interface`.includedApplications.apply {
                            clear()
                            addAll(stepPackageList)
                        }

                        tunnel.setConfigAsync(config.resolve())
                    } else {
                        config.`interface`.excludedApplications.clear()
                        config.`interface`.includedApplications.clear()
                        tunnel.setConfigAsync(config.resolve())
                    }
                }

            }


            Application.getTunnelManager().setTunnelState(tunnel, Tunnel.State.UP)
            Application.getCacheManager().writeString("connection_epoch", System.currentTimeMillis().toString())

            Log.e("Config Export", tunnel.config?.toWgQuickString() ?: "")
//            findNavController().navigate(R.id.action_statusFragment_to_tunnelEditorFragment)
        }
    }

    private suspend fun deleteEverything() {
        Log.e(TAG, "deleteEverything")
        Application.getTunnelManager().getTunnels().forEach { tunnel ->
            Application.getTunnelManager().delete(tunnel)
        }
        val cacheManager = Application.getCacheManager()
        cacheManager.writeString("is_logged_in", "false")
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Location Service Channel",
                NotificationManager.IMPORTANCE_MIN
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    private fun getNotification(): Notification {
        val notificationIntent = Intent(this, HomeActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent,
            PendingIntent.FLAG_MUTABLE
        )
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("MobileItmVPN")
            .setContentText("VPN Service")
            .setSmallIcon(R.drawable.ic_logo)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            builder.setForegroundServiceBehavior(Notification.FOREGROUND_SERVICE_IMMEDIATE)
        }
        return builder.build()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    fun stopService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stopForeground(STOP_FOREGROUND_DETACH)
        } else {
            stopForeground(true)
        }
        stopSelf()
    }

    /*
    private suspend fun isConnected(ip: String): Boolean {
        try {
            TrafficStats.setThreadStatsTag(42)
            val address = InetAddress.getByName(ip)
            val reachable = address.isReachable(5000)
            return reachable
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return false
        }
    }
    */

    companion object {
        val ACTION_RESET: String = "com.wireguard.android.VpnSyncService.RESET"
        val ACTION_STOP: String = "com.wireguard.android.VpnSyncService.STOP"
    }

    private fun logoutAndRestartApp() {
        CoroutineScope(Dispatchers.IO).launch {
            deleteEverything()
            withContext(Dispatchers.Main) {
                stopSelf()
                val intent = Intent(Application.instance, HomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                }
                Application.instance.startActivity(intent)
            }
        }
    }

    private suspend fun disconnectTunnelIfNeeded() {
        val tunnels = Application.getTunnelManager().getTunnels()
        if (tunnels.isNotEmpty()) {
            Application.getTunnelManager().setTunnelState(tunnels.first(), Tunnel.State.DOWN)
        }
    }

    private fun refreshToken(){
        Log.d("AccessTokenCheck","RefreshToken metoduna girildi")
        val manageConfigIsChanged = Application.getCacheManager().readBoolean("manage_config_changed",false)

        CoroutineScope(Dispatchers.IO).launch {
            refreshTokenUseCase().collect{result ->
                when(result){
                    is Result.Success -> {

                        Log.d(
                            "AccessTokenCheck",
                            "VpnSyncService (Refresh Token Method Succesfull) have a new refresh token :${result.data.tokens.refreshToken}"
                        )
                        Log.d(
                            "AccessTokenCheck",
                            "VpnSyncService(Refresh Token Method Succesfull) have a new access token :${result.data.tokens.accessToken}"
                        )
                        Log.d("AccessTokenCheck", "Refresh Token Config alındı")
                        SessionManager.saveRefreshToken(result.data.tokens.refreshToken)
                        SessionManager.saveAuthToken(result.data.tokens.accessToken)
                        Application.getCacheManager().writeBoolean("last_state", true)
                        val configText = result.data.config
                        updateTunnelIfNeeded(configText,manageConfigIsChanged)
                    }
                    is Result.Error ->{
                        Log.e("AccessTokenCheck", " Refresh Token Geçersiz. Çıkış yapılıyor.")
                        disconnectTunnelIfNeeded()
                        logoutAndRestartApp()
                    }
                }

            }
        }
    }

    private fun fetchNewConfig() {

        val cacheManager = Application.getCacheManager()
        val manageConfigIsChanged = cacheManager.readBoolean("manage_config_changed", false)

        if (AdminKnobs.host.isEmpty() || AdminKnobs.port.isEmpty()){
            logoutAndRestartApp()
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            fetchConfigUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        val configText = result.data
                        Log.d("VpnSyncService", "Fetchconfig :Config alındı ve işleniyor")
                        Log.e("VpnSyncService",result.data)
                        cacheManager.writeBoolean("last_state", true)
                        updateTunnelIfNeeded(configText,manageConfigIsChanged)
                    }
                    is Result.Error -> {
                        when(result.error){
                            DataError.Network.UNAUTHORIZED -> {
                                Log.e("VpnSyncService", "fetchConfig hatası: ${result.error} refreshOken çağrıldı")
                                refreshToken()
                            }
                            else ->{
                                Log.e("VpnSyncService", "fetchConfig hatası: ${result.error}")
                                //disconnectTunnelIfNeeded()
                                logoutAndRestartApp()
                            }
                        }
                    }
                }
                checkVpnDelayed()
            }
        }
    }

    private suspend fun updateTunnelIfNeeded(configText: String, manageConfigIsChanged: Boolean) {
        val byteArray = configText.toByteArray(Charsets.UTF_8)
        val is1 = ByteArrayInputStream(byteArray)
        val is2 = ByteArrayInputStream(byteArray)

        val tunnels = Application.getTunnelManager().getTunnels()
        val firstTunnel = tunnels.firstOrNull()

        if (!checkPrivateKey(is1) || firstTunnel?.state == Tunnel.State.DOWN || manageConfigIsChanged) {
            tunnels.forEach { tunnel ->
                Application.getTunnelManager().delete(tunnel)
            }

            TunnelImporter.importTunnelFromRaw(is2) {
                CoroutineScope(Dispatchers.IO).launch {
                    Application.getTunnelManager().getTunnels().firstOrNull()?.let {
                        connectToTunnel(it, false)
                    }
                }
            }
        }
    }

}