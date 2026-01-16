/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wireguard.android.Application
import com.wireguard.android.common.Result
import com.wireguard.android.common.knobs.AdminKnobs
import com.wireguard.android.common.knobs.ProfileManager
import com.wireguard.android.domain.usecase.get_login_methods.GetLoginMethodsUseCase
import com.wireguard.android.presentation.common.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val getLoginMethodsUseCase: GetLoginMethodsUseCase,
    private val errorMapper: ErrorMapper

): ViewModel()  {
    private val  _uiState = MutableStateFlow<StartUiState>(StartUiState.Idle)
    val uiState : StateFlow<StartUiState> = _uiState

    private val _event = MutableSharedFlow<StartUiEvent>()
    val event: SharedFlow<StartUiEvent> = _event

    private fun fetchLoginMethods(){
        viewModelScope.launch {
            _uiState.emit(StartUiState.Loading)

            getLoginMethodsUseCase().collect{result->
                when(result){
                    is Result.Success -> {
                        _uiState.emit(StartUiState.Success(result.data))
                        _event.emit(StartUiEvent.NavigateToManualSetup(result.data))
                    }

                    is Result.Error -> {
                        _uiState.emit(StartUiState.Idle)
                        val uiText = errorMapper.mapToUiText(result.error)

                        _event.emit(StartUiEvent.ShowError(uiText))
                        _event.emit(StartUiEvent.NavigateToProfileWithData(shouldFillFields = false)) // loginMethods yoksa
                    }
                }

            }
        }
    }



     fun continueToApp(){
        viewModelScope.launch {
            if (Application.getTunnelManager().getTunnels().isNotEmpty()){
                _event.emit(StartUiEvent.NavigateToStatus)
                return@launch
            }
            val activeProfile = ProfileManager.getActiveProfile()
            if (activeProfile == null) {
                _event.emit(StartUiEvent.NavigateToProfile)
                return@launch
            }
            fetchLoginMethods()
        }
    }
}