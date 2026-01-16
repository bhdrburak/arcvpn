/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.manuelsetup

import android.os.Bundle
import android.security.KeyChain
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.wireguard.android.Application
import com.wireguard.android.presentation.common.BaseLoginFragment
import com.wireguard.android.BuildConfig
import com.wireguard.android.R
import com.wireguard.android.common.error.ValidationFieldType
import com.wireguard.android.databinding.FragmentManualSetupBinding
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.presentation.common.ValidationErrorState
import com.wireguard.android.presentation.common.uihelpers.Helpers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.security.KeyStore
import java.security.cert.X509Certificate

@AndroidEntryPoint
class ManualSetupFragment : BaseLoginFragment() {

    private var _binding: FragmentManualSetupBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ManualSetupViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentManualSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appBar.ibAction.visibility = View.VISIBLE
        binding.appBar.ibAction.setImageResource(R.drawable.logout)
        observeUiState()
        observeEvents()

        binding.appBar.ibAction.setOnClickListener {
            showDeleteConfirmation()
        }

        binding.etUsername.addTextChangedListener { checkLoginButton() }
        binding.etPassword.addTextChangedListener { checkLoginButton() }

        binding.btnLogin.setOnClickListener {
            tryLogin()
        }

        binding.btnSelectCertificate.setOnClickListener {
            selectCertificateDialog()
        }

        setupByArgs()

        if (BuildConfig.DEBUG) {
            binding.etUsername.setText("admin@admin.com")
            binding.etPassword.setText("f911Ya8.Ry5")
        }
        //disableBackPress()

    }

    private fun setupByArgs() {
        val credential = arguments?.getBoolean("credential") == true
        val cert = arguments?.getBoolean("certification") == true

        binding.etUsername.isVisible = credential
        binding.etPassword.isVisible = credential
        binding.btnSelectCertificate.isVisible = cert
    }

    private fun tryLogin() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        val requireCredential = arguments?.getBoolean("credential") == true
        val requireCert = arguments?.getBoolean("certification") == true

        viewModel.onLoginClicked(username, password, requireCredential, requireCert)
    }

    private fun observeUiState() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is ManuelSetupUiState.Loading -> {
                        binding.progressBar.isVisible = true
                        clearFieldErrors()
                    }
                    is ManuelSetupUiState.ValidationErrors -> {
                        binding.progressBar.isVisible = false
                        showValidationErrors(state.errors)
                    }
                    is ManuelSetupUiState.Idle -> {
                        binding.progressBar.isVisible = false
                        clearFieldErrors()
                    }
                    is ManuelSetupUiState.Success -> {
                        binding.progressBar.isVisible = false
                        // opsiyonel: ek bilgi gösterilebilir
                    }
                }
            }
        }
    }

    private fun observeEvents() {
        lifecycleScope.launch {
            viewModel.event.collect { event ->
                when (event) {
                    is ManuelSetupUiEvent.ShowError -> {
                        Helpers.showCustomSnackbar(binding.root,event.message.asString(requireContext()))

                    }
                    is ManuelSetupUiEvent.NavigateToStatus -> {
                        findNavController().navigate(R.id.action_manualSetupFragment_to_statusFragment)
                    }
                    else -> {}

                }
            }
        }
    }
    private fun clearFieldErrors() {
        binding.etUsername.error = null
        binding.etPassword.error = null
    }
    private fun showValidationErrors(errors: ValidationErrorState) {
        val map = errors.fieldErrors
        binding.etUsername.error = map[ValidationFieldType.EMAIL]?.asString(requireContext())
        binding.etPassword.error = map[ValidationFieldType.PASSWORD]?.asString(requireContext())
        map[ValidationFieldType.CERTIFICATE]?.let {
            Toast.makeText(requireContext(), it.asString(requireContext()), Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearProfileCache() {
        val cacheManager = Application.getCacheManager()
        ProfileManager.clearActiveSelectedProfile()
        cacheManager.writeBoolean("manage_config_changed", false)

    }

    private fun showDeleteConfirmation() {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.logout_profile_dialog_title))
            .setMessage(getString(R.string.logout_profile_dialog_message))
            .setPositiveButton(getString(R.string.button_yes_text)) { _, _ ->
                clearProfileCache()
                findNavController().navigate(R.id.action_manualSetupFragment_to_configurationProfilesFragment)
            }
            .setNegativeButton(getString(R.string.button_no_text)) { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

    private fun getCertificate(alias: String) {
        try {
            val context = requireContext()
            val cert = KeyChain.getCertificateChain(context, alias)?.firstOrNull() as? X509Certificate
            cert?.let {
                viewModel.onCertificateSelected(it)
                binding.btnSelectCertificate.text = it.subjectDN.name
                checkLoginButton()
            }
        } catch (e: Exception) {
            Log.e("KeyChain", "Sertifika alınırken hata", e)
        }
    }

    private fun selectAppCertificate() {
        try {
            KeyChain.choosePrivateKeyAlias(
                requireActivity(),
                { alias ->
                    alias?.let { getCertificate(it) }
                }, null, null, null, -1, ""
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun selectCertificateDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Bir sertifika seçin")
            .setItems(arrayOf("Uygulama sertifikası seç", "CA sertifikası seç")) { _, which ->
                when (which) {
                    0 -> selectAppCertificate()
                    1 -> selectCaCertificate()
                }
            }
            .show()
    }

    private fun selectCaCertificate() {
        val globalCerts = mutableListOf<X509Certificate>()
        val certNames = mutableListOf<String>()

        try {
            val ks = KeyStore.getInstance("AndroidCAStore").apply { load(null, null) }
            val aliases = ks.aliases()
            while (aliases.hasMoreElements()) {
                val alias = aliases.nextElement()
                val cert = ks.getCertificate(alias) as? X509Certificate
                cert?.let {
                    globalCerts.add(it)
                    certNames.add(it.issuerDN.name)
                }
            }

            AlertDialog.Builder(requireContext())
                .setTitle("CA Sertifikası Seçin")
                .setItems(certNames.toTypedArray()) { _, which ->
                    viewModel.onCertificateSelected(globalCerts[which])
                    binding.btnSelectCertificate.text = globalCerts[which].subjectDN.name
                    checkLoginButton()
                }
                .show()

        } catch (e: Exception) {
            Log.e("CA", "CA sertifikası alınamadı", e)
        }
    }

    private fun checkLoginButton() {
        val credential = arguments?.getBoolean("credential") == true
        val cert = arguments?.getBoolean("certification") == true
        val isUsernameFilled = binding.etUsername.text?.isNotEmpty() == true
        val isPasswordFilled = binding.etPassword.text?.isNotEmpty() == true
        val isCertSelected = viewModel.selectedCertificate != null

        val shouldEnable = (!credential || (isUsernameFilled && isPasswordFilled)) &&
                (!cert || isCertSelected)

        binding.btnLogin.isEnabled = shouldEnable
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun disableBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val activeProfile = ProfileManager.getActiveProfile()
                    if (activeProfile == null) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    } else {
                        Helpers.showCustomSnackbar(
                            requireView(),
                            getString(R.string.on_back_pressed_message)
                        )
                    }
                }
            }
        )
    }


}
