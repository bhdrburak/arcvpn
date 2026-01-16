/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.start

import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.presentation.common.UiText

sealed interface StartUiEvent {
    data class ShowError(val message: UiText) : StartUiEvent
    data object NavigateToProfile : StartUiEvent
    data class NavigateToManualSetup(val loginMethods: LoginMethods) : StartUiEvent
    data object NavigateToStatus : StartUiEvent
    data class NavigateToProfileWithData(val shouldFillFields: Boolean) : StartUiEvent

}
