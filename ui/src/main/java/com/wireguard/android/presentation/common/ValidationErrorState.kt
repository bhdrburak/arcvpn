/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.common

import com.wireguard.android.common.error.ValidationFieldType

data class ValidationErrorState(
    val fieldErrors: Map<ValidationFieldType, UiText> = emptyMap()
)
