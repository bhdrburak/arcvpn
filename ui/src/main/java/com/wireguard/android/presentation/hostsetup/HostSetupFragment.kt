/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.hostsetup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.wireguard.android.Application
import com.wireguard.android.presentation.common.BaseLoginFragment
import com.wireguard.android.R
import com.wireguard.android.common.error.UserDataValidator
import com.wireguard.android.common.error.ValidationFieldType
import com.wireguard.android.databinding.FragmentHostSetupBinding
import com.wireguard.android.presentation.common.ErrorMapper
import com.wireguard.android.presentation.common.UiText
import com.wireguard.android.presentation.common.uihelpers.Helpers
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.wireguard.android.common.Result
import com.wireguard.android.common.knobs.ProfileManager


@AndroidEntryPoint
class HostSetupFragment : BaseLoginFragment() {

    @Inject
    lateinit var errorMapper: ErrorMapper

    @Inject
    lateinit var userDataValidator: UserDataValidator

    private var _binding: FragmentHostSetupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHostSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener { triggerSave() }
        binding.etServerAddress.addTextChangedListener { checkContinueButton() }
        binding.etPort.addTextChangedListener { checkContinueButton() }
        binding.etConnectionName.addTextChangedListener { checkContinueButton() }
    }

    private fun triggerSave() {
        clearFieldErrors()

        val host = binding.etServerAddress.text.toString()
        val port = binding.etPort.text.toString()
        val connectionName = binding.etConnectionName.text.toString()

        val fieldErrors = mutableMapOf<ValidationFieldType, UiText>()

        val hostResult = userDataValidator.validateHost(host)
        if (hostResult is Result.Error) {
            errorMapper.mapValidationErrorToField(hostResult.error).let {
                fieldErrors[it.first] = it.second
            }
        }

        val portResult = userDataValidator.validatePort(port)
        if (portResult is Result.Error) {
            errorMapper.mapValidationErrorToField(portResult.error).let {
                fieldErrors[it.first] = it.second
            }
        }

        val nameResult = userDataValidator.validateConnectionName(connectionName)
        if (nameResult is Result.Error) {
            errorMapper.mapValidationErrorToField(nameResult.error).let {
                fieldErrors[it.first] = it.second
            }
        }

        if (fieldErrors.isNotEmpty()) {
            showValidationErrors(fieldErrors)
            return
        }

        try {
            ProfileManager.addUserProfileToCache(host, port, connectionName)
            navigateToProfile()
        } catch (e: Exception) {
            Helpers.showCustomSnackbar(binding.root, getString(R.string.profile_save_failed))
        }
    }

    private fun navigateToProfile() {

        findNavController().navigate(R.id.action_hostSetupFragment_to_configurationProfilesFragment)
    }

    private fun checkContinueButton() {
        val enable = binding.etServerAddress.text?.isNotEmpty() == true &&
                binding.etPort.text?.isNotEmpty() == true &&
                binding.etConnectionName.text?.isNotEmpty() == true
        binding.btnSave.isEnabled = enable
    }



    private fun clearFieldErrors() {
        binding.etServerAddress.error = null
        binding.etPort.error = null
        binding.etConnectionName.error = null
    }

    private fun showValidationErrors(errors: Map<ValidationFieldType, UiText>) {
        binding.etServerAddress.error = errors[ValidationFieldType.HOST]?.asString(requireContext())
        binding.etPort.error = errors[ValidationFieldType.PORT]?.asString(requireContext())
        binding.etConnectionName.error = errors[ValidationFieldType.NAME]?.asString(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
