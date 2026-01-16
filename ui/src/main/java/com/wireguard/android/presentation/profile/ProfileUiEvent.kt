/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.profile

import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.presentation.common.UiText

sealed interface ProfileUiEvent {
    data class ShowError(val message: UiText) : ProfileUiEvent
    data class NavigateToManualSetup(val loginMethods: LoginMethods) : ProfileUiEvent
}