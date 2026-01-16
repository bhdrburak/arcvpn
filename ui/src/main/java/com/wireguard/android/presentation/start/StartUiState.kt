/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.start

import com.wireguard.android.domain.model.LoginMethods

sealed class StartUiState {
    data object Idle : StartUiState()
    data object Loading : StartUiState()
    data class Success(val data: LoginMethods) : StartUiState()
}
