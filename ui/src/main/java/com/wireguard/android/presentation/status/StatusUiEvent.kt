package com.wireguard.android.presentation.status

import com.wireguard.android.data.remote.dto.QuickConfig
import com.wireguard.android.presentation.common.UiText


sealed interface StatusUiEvent {
    data class ShowError(val message: UiText) : StatusUiEvent
    data class NavigateToQuickConnect(val quickConnect: QuickConfig) : StatusUiEvent

}