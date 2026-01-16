/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.mapper

import com.wireguard.android.data.remote.dto.LoginMethodResponseDto
import com.wireguard.android.domain.model.LoginMethods

fun LoginMethodResponseDto.toDomain(): LoginMethods {
    return LoginMethods(
        credential = credential,
        certification = certification,
        validDevice = validDevice
    )
}