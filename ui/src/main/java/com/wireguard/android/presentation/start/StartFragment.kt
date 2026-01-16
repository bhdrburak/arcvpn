/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.start

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.wireguard.android.R
import com.wireguard.android.common.knobs.AdminKnobs
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.databinding.FragmentStartBinding
import com.wireguard.android.presentation.common.BaseFragment
import com.wireguard.android.presentation.common.uihelpers.Helpers
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [StartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class StartFragment : BaseFragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StartViewModel by viewModels()

    companion object {
        private val TAG = StartFragment::class.java.simpleName
    }
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            //continueToApp()
            viewModel.continueToApp()

        } else {

            Snackbar.make(
                binding.root,
                String.format(
                    String.format(
                        getString(R.string.txt_error_post_notification),
                        getString(R.string.app_name)
                    )
                ),
                Snackbar.LENGTH_INDEFINITE
            ).setAction(getString(R.string.goto_settings)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    val settingsIntent: Intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .putExtra(Settings.EXTRA_APP_PACKAGE, requireActivity().packageName)
                    startActivity(settingsIntent)
                }
            }.show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        CertificateHelper.initKeyChain(requireActivity())
//        CertificateHelper.getSecurityCertificates()
        askNotificationPermission()
        observeViewModel()
        ProfileManager.updateFromRestrictions()
    }

    private fun askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.POST_NOTIFICATIONS) ==
                PackageManager.PERMISSION_GRANTED
            ) {
                //continueToApp()
                viewModel.continueToApp()
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        } else {
            //continueToApp()
            viewModel.continueToApp()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.continueToApp()
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.event.collect { event ->
                when (event) {
                    is StartUiEvent.ShowError -> {
                        Helpers.showCustomSnackbar(binding.root,event.message.asString(requireContext()))
                    }

                    is StartUiEvent.NavigateToManualSetup -> {
                        val bundle = Bundle().apply {
                            putBoolean("credential", event.loginMethods.credential)
                            putBoolean("certification", event.loginMethods.certification)
                            putBoolean("validDevice", event.loginMethods.validDevice)
                        }
                        if (findNavController().currentDestination?.id == R.id.startFragment) {
                            findNavController().navigate(R.id.action_startFragment_to_manualSetupFragment, bundle)
                        }
                    }

                    StartUiEvent.NavigateToProfile -> {
                        if (findNavController().currentDestination?.id == R.id.startFragment) {
                            findNavController().navigate(R.id.action_startFragment_to_configurationProfilesFragment)
                        }
                    }

                    StartUiEvent.NavigateToStatus -> {
                        if (findNavController().currentDestination?.id == R.id.startFragment) {
                            findNavController().navigate(R.id.action_startFragment_to_statusFragment)
                        }
                    }

                    is StartUiEvent.NavigateToProfileWithData -> {
                        if (findNavController().currentDestination?.id == R.id.startFragment) {
                            val bundle = Bundle().apply {
                                putBoolean("shouldFillFields", event.shouldFillFields)
                            }
                            findNavController().navigate(R.id.action_startFragment_to_configurationProfilesFragment, bundle)
                        }
                    }
                }
            }
        }
    }
}