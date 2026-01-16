/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.manuelsetup

import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.presentation.common.UiText

sealed interface ManuelSetupUiEvent {
    data class ShowError(val message: UiText) : ManuelSetupUiEvent
    data object NavigateToStatus : ManuelSetupUiEvent
    data object NavigateToHostSetup : ManuelSetupUiEvent

}