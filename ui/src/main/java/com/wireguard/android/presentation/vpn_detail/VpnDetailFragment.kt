package com.wireguard.android.presentation.vpn_detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wireguard.android.Application
import com.wireguard.android.R
import com.wireguard.android.backend.GoBackend
import com.wireguard.android.backend.Tunnel
import com.wireguard.android.common.knobs.AdminKnobs
import com.wireguard.android.common.util.QuantityFormatter
import com.wireguard.android.data.remote.dto.QuickConfig
import com.wireguard.android.databinding.FragmentVpnDetailBinding
import com.wireguard.android.model.ObservableTunnel
import com.wireguard.android.presentation.common.BaseFragment
import com.wireguard.android.presentation.service.VpnSyncService
import com.wireguard.android.viewmodel.ConfigProxy
import com.wireguard.config.Peer
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class VpnDetailFragment : BaseFragment() {
    private var _binding: FragmentVpnDetailBinding? = null
    private val binding get() = _binding!!

    private var timerActive = true
    private val tunnelManager = Application.getTunnelManager()

    private var lastState = false
    private var config: QuickConfig? = null
    private var configId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVpnDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        config = arguments?.getParcelable("quick_config", QuickConfig::class.java)
        configId = arguments?.getInt("config_id") ?: -1
        binding.appBar.ibAction.visibility = View.GONE
        updateLogoutButtonVisibility()

        binding.ivConnectionStatus.setOnClickListener {

            lifecycleScope.launch {
                if (tunnelManager.getTunnels().isNotEmpty()) {
                    val tunnel = tunnelManager.getTunnels().first()
                    if (tunnel.state == Tunnel.State.UP && tunnel?.getStatisticsAsync()
                            ?.peer(tunnel.config?.peers?.firstOrNull()?.publicKey)?.latestHandshakeEpochMillis ?: 0 <= 0
                    ) {
                        tunnelManager.setTunnelState(tunnel, Tunnel.State.DOWN)
                        connectToTunnel(tunnel, false)
                    } else {
                        connectToTunnel(tunnel, false)
                        binding.tvConnectionname.text = AdminKnobs.connectionName
                        binding.tvIp.text = tunnel.config?.peers?.firstOrNull()?.endpoint?.get()?.host
                        binding.tvUsername.text = Application.getCacheManager().read("username", "")
                    }
                } else {
                    startService(false)
                }
            }
        }
        /*
        VpnSyncService.refreshTokenFailed.observe(viewLifecycleOwner) { isChanged ->
            if (isChanged) {
                Handler(Looper.getMainLooper()).post {
                    val intent2 = Intent(
                        Application.instance,
                        HomeActivity::class.java
                    ).also {
                        it.action = Constants.ACTION_LOGIN
                    }
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    Application.instance.startActivity(intent2)
                }
            }
        }
        */

    }

    private fun updateLogoutButtonVisibility() {
        if (!AdminKnobs.alwaysOnConnection) {
            binding.btnLogout.visibility = View.VISIBLE
            //binding.appBar.ibAction.setImageResource(R.drawable.ic_logout)
            binding.btnLogout.setOnClickListener {
                lifecycleScope.launch {
                    deleteEverything()
                }
            }
        } else {
            binding.btnLogout.visibility = View.GONE
        }
    }

    private fun connectToTunnel(tunnel: ObservableTunnel, forceReset: Boolean) {
        Log.e(TAG, "connectToTunnel")


        binding.tvConnectionname.text = AdminKnobs.connectionName ?: tunnel.config?.peers?.firstOrNull()?.endpoint?.get()?.host
        binding.tvIp.text = tunnel.config?.peers?.firstOrNull()?.endpoint?.get()?.host
        binding.tvUsername.text = Application.getCacheManager().read("username", "")

        if (!forceReset && tunnel.state == Tunnel.State.UP) {
            lastPing = System.currentTimeMillis()
            onConnected()
            return
        }

        if (forceReset) {
            setTunnelStateWithPermissionsResult(tunnel, false)
            onDisconnected()
        }

        activity?.lifecycleScope?.launch {
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

                updateLogoutButtonVisibility()
            }

            if (Application.getBackend() is GoBackend) {
                try {
                    val intent = GoBackend.VpnService.prepare(activity)
                    if (intent != null) {
                        pendingTunnel = tunnel
                        pendingTunnelUp = true
                        permissionActivityResultLauncher.launch(intent)
                        Log.e(TAG, "returning")
                        return@launch
                    }
                } catch (e: Throwable) {
                }
            }

            setTunnelStateWithPermissionsResult(tunnel, true)
            onConnected(true)

            Log.e("Config Export", tunnel.config?.toWgQuickString() ?: "")
//            findNavController().navigate(R.id.action_statusFragment_to_tunnelEditorFragment)
        }
    }

//    private fun imitateConfigChangeDelayed() {
//        compositeDisposable?.add(
//            Completable.timer(
//                30000L,
//                TimeUnit.MILLISECONDS,
//                AndroidSchedulers.mainThread()
//            ).andThen(
//                Completable
//                    .create { emitter ->
//                        onRestrictionsChanged()
//                        imitateConfigChangeDelayed()
//                        emitter.onComplete()
//                    }
//            ).subscribe()
//        )
//    }


    private fun onDisconnected() {
        Log.e(TAG, "onDisconnected")
        timerActive = false

        binding.ivConnectionStatus.setImageResource(R.drawable.ic_status_disconnected)
        binding.ivConnectionnameSignal.setImageResource(R.drawable.ic_signal_disconnected)
        binding.tvConnectionStatus.text = ContextCompat.getString(requireContext(), R.string.disconnected)
        binding.clStatusTop.setBackgroundResource(R.drawable.bg_connectionstatus_disconnected)
        binding.tvConnectionnameTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
        binding.tvConnectionname.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))

        // TODO stop service
        stopService()
    }

    private fun stopService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.also { safeContext ->
                val intent = Intent(safeContext, VpnSyncService::class.java) // Build the intent for the service
                intent.action = VpnSyncService.ACTION_STOP
                safeContext.startService(intent)
            }
        }
    }

    private fun startService(willReset: Boolean = false) {
        Log.e(TAG, "startService, willReset= $willReset")
        context?.also { safeContext ->
            val intent = Intent(safeContext, VpnSyncService::class.java).apply {
                putExtra("vpn_config", config)
                putExtra("config_id", configId)
            }
            if (willReset) intent.action = VpnSyncService.ACTION_RESET

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                safeContext.startForegroundService(intent)
            } else {
                safeContext.startService(intent)
            }
        }
    }

    private fun onConnected(resetEpoch: Boolean = false) {
        Log.e(TAG, "onConnected, resetEpoch= ${resetEpoch}")
        lastPing = System.currentTimeMillis()
        if (resetEpoch) Application.getCacheManager().writeString("connection_epoch", System.currentTimeMillis().toString())
        timerActive = true
        // TODO start service
        startService()
    }

    override fun onResume() {
        super.onResume()
        timerActive = true
        compositeDisposable?.add(
            Observable.interval(1, TimeUnit.SECONDS)
                .subscribe {
                    lifecycleScope.launch {
                        updateStats()
                    }
                }
        )
        updateLogoutButtonVisibility()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()
        Application.getCacheManager().writeBoolean("last_state", lastState)
    }

    private suspend fun updateStats() {
        Log.e(TAG, "updateStats: timerActive=$timerActive")
        try {
            val cacheManager = Application.getCacheManager()
            val tunnel = tunnelManager.getTunnels().firstOrNull()
            val stats = tunnel?.getStatisticsAsync()
            lastState = cacheManager.readBoolean("last_state", false)

            if (stats != null) {
                val peer: Peer? = tunnel.config?.peers?.firstOrNull()
                val peerPublicKey = peer?.publicKey
                if (peerPublicKey != null) {
                    val peerStats = stats.peer(peerPublicKey)
                    val latestEpochMillis = peerStats?.latestHandshakeEpochMillis
                    if (tunnel.state == Tunnel.State.UP && Application.getCacheManager().readString("connection_epoch", "").isEmpty()) {
                        Application.getCacheManager().writeString("connection_epoch", System.currentTimeMillis().toString())
                    }
                    val connectionEpochMillis = Application.getCacheManager().readString("connection_epoch", System.currentTimeMillis().toString()).toLong()
                    Log.w(
                        TAG,
                        "state: ${tunnel?.state} stats: $peerStats isStale: ${stats.isStale} Latest handshake: $latestEpochMillis connectionEpochMillis: $connectionEpochMillis"
                    )
                    if (latestEpochMillis != null
                        && latestEpochMillis > 0
                        && connectionEpochMillis > 0
                    ) {
                        Log.e(TAG, "updateStats: timerActive=$timerActive")
                        try {
                            lastState = true
                            binding.tvIp.text = AdminKnobs.host.replace("https://", "")
                            binding.tvConnectionname.text = AdminKnobs.connectionName
                            if (timerActive) binding.tvDuration.text = QuantityFormatter.formatEpochAgo(connectionEpochMillis)
                            binding.ivConnectionStatus.setImageResource(R.drawable.ic_status_connected)
                            binding.ivConnectionnameSignal.setImageResource(R.drawable.ic_signal_connected)
                            binding.tvConnectionStatus.text = ContextCompat.getString(requireContext(), R.string.connected)
                            binding.clStatusTop.setBackgroundResource(R.drawable.bg_connectionstatus_connected)
                            binding.tvConnectionnameTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                            binding.tvConnectionname.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                            binding.tvUsername.text = Application.getCacheManager().read("username", "")
                            updateLogoutButtonVisibility()

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    } else {
                        lastState = false
                        binding.tvIp.text = AdminKnobs.host.replace("https://", "")
                        binding.tvConnectionname.text = AdminKnobs.connectionName
                        binding.tvDuration.text = ""
                        binding.ivConnectionStatus.setImageResource(R.drawable.ic_status_disconnected)
                        binding.ivConnectionnameSignal.setImageResource(R.drawable.ic_signal_disconnected)
                        binding.tvConnectionStatus.text = ContextCompat.getString(requireContext(), R.string.disconnected)
                        binding.clStatusTop.setBackgroundResource(R.drawable.bg_connectionstatus_disconnected)
                        binding.tvConnectionnameTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                        binding.tvConnectionname.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                        binding.tvUsername.text = Application.getCacheManager().read("username", "")
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error updating stats", e)
        }
    }

    private suspend fun deleteEverything() {
        Log.e(TAG, "deleteEverything")
        stopService()
        tunnelManager.getTunnels().forEach { tunnel ->
            tunnelManager.delete(tunnel)
        }

        compositeDisposable?.clear()
        if (Application.getCacheManager().readString("is_logged_in", "false").equals("true")
        ){
            Application.getCacheManager().writeString("is_logged_in", "false")
        }
        findNavController().popBackStack()
    }
}