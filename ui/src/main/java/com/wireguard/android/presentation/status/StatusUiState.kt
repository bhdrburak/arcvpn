package com.wireguard.android.presentation.status

import com.wireguard.android.data.remote.dto.AllNodeModel
import com.wireguard.android.data.remote.dto.LoginResponseModel
import com.wireguard.android.presentation.common.ValidationErrorState


sealed class StatusUiState {
    data object Idle : StatusUiState()
    data object Loading : StatusUiState()
    data class Success(val data: AllNodeModel) : StatusUiState()
    data class ValidationErrors(val errors: ValidationErrorState) : StatusUiState()
}