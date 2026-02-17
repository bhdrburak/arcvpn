/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.manuelsetup

import android.os.Build
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wireguard.android.Application
import com.wireguard.android.common.error.UserDataValidator
import com.wireguard.android.common.error.ValidationError
import com.wireguard.android.common.error.ValidationFieldType
import com.wireguard.android.domain.usecase.login.LoginUseCase
import com.wireguard.android.presentation.common.ErrorMapper
import com.wireguard.android.presentation.common.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.security.cert.X509Certificate
import javax.inject.Inject
import com.wireguard.android.common.Result
import com.wireguard.android.common.session.SessionManager
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.util.DeviceInfoProvider
import com.wireguard.android.presentation.common.ValidationErrorState
import com.wireguard.android.common.util.TunnelImporter


@HiltViewModel
class ManualSetupViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val errorMapper: ErrorMapper,
    private val userDataValidator: UserDataValidator,
    private val deviceInfoProvider: DeviceInfoProvider

):ViewModel(){

    private val _uiState = MutableStateFlow<ManuelSetupUiState>(ManuelSetupUiState.Idle)
    val uiState: StateFlow<ManuelSetupUiState> = _uiState

    private val _event = MutableSharedFlow<ManuelSetupUiEvent>()
    val event: SharedFlow<ManuelSetupUiEvent> = _event

    var selectedCertificate: X509Certificate? = null
        private set



    fun onCertificateSelected(cert: X509Certificate) {
        selectedCertificate = cert
    }
    private fun login(username: String, password: String) {

        viewModelScope.launch {
            _uiState.value = ManuelSetupUiState.Loading
            loginUseCase(LoginData(username, password)).collect { result ->
                when (result) {
                    is Result.Success -> {
                        SessionManager.saveAuthToken(result.data.token)
                        //SessionManager.saveRefreshToken(result.data.tokens.refreshToken)
                        SessionManager.setLoggedIn(true)

                        Application.getTunnelManager().getTunnels().forEach { tunnel ->
                            tunnel.deleteAsync()
                        }

                        Application.getTunnelManager().getTunnels().forEach { it.deleteAsync() }
                        /*TunnelImporter.importTunnelFromRaw(result.data.config.byteInputStream()) {
                            viewModelScope.launch {
                                _event.emit(ManuelSetupUiEvent.NavigateToStatus)
                            }
                        }*/
                        _uiState.value = ManuelSetupUiState.Success(result.data)
                        _event.emit(ManuelSetupUiEvent.NavigateToStatus)
                    }
                    is Result.Error -> { // config boşsa buraya düşecek use case handle edildi.
                        _uiState.value = ManuelSetupUiState.Idle
                        _event.emit(ManuelSetupUiEvent.ShowError(errorMapper.mapToUiText(result.error)))
                    }
                }
            }
        }
    }

    fun onLoginClicked(username :String, password: String){
        val fieldErrors = mutableMapOf<ValidationFieldType, UiText>()


        if (fieldErrors.isNotEmpty()) {
            _uiState.value = ManuelSetupUiState.Idle // önce sıfırla
            _uiState.value = ManuelSetupUiState.ValidationErrors(ValidationErrorState(fieldErrors))
            return
        }

        login(username, password)
    }

}