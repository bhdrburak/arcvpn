/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.manuelsetup

import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.presentation.common.ValidationErrorState

sealed class ManuelSetupUiState {
    data object Idle : ManuelSetupUiState()
    data object Loading : ManuelSetupUiState()
    data class Success(val data: MasterData) : ManuelSetupUiState()
    data class ValidationErrors(val errors: ValidationErrorState) : ManuelSetupUiState()
}