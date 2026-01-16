/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.common

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {
    data class StringResource(@StringRes val resId: Int) : UiText()
    data class DynamicString(val message: String) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is StringResource -> context.getString(resId)
            is DynamicString -> message
        }
    }
}
