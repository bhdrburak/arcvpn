/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wireguard.android.domain.usecase.get_login_methods.GetLoginMethodsUseCase
import com.wireguard.android.presentation.common.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import com.wireguard.android.common.Result
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.domain.model.VpnProfile
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel@Inject constructor(
    private val getLoginMethodsUseCase: GetLoginMethodsUseCase,
    private val errorMapper: ErrorMapper,
) : ViewModel() {

    private val  _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Idle)
    val uiState : StateFlow<ProfileUiState> = _uiState

    private val _event = MutableSharedFlow<ProfileUiEvent>()
    val event: SharedFlow<ProfileUiEvent> = _event

    fun onProfileSelected(profile: VpnProfile) {
        ProfileManager.setActiveProfile(profile.id,profile.isUserProfile)

        _uiState.value = ProfileUiState.Loading

        viewModelScope.launch {
            getLoginMethodsUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _uiState.value = ProfileUiState.Success(result.data)
                        _event.emit(ProfileUiEvent.NavigateToManualSetup(result.data))
                    }

                    is Result.Error -> {
                        _uiState.value = ProfileUiState.Idle
                        _event.emit(ProfileUiEvent.ShowError(errorMapper.mapToUiText(result.error)))
                        ProfileManager.clearActiveSelectedProfile()
                    }
                }
            }
        }
    }

}