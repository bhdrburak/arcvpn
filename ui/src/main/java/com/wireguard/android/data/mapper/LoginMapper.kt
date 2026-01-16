/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.mapper

import com.wireguard.android.data.remote.dto.LoginRequest
import com.wireguard.android.data.remote.dto.MasterResponseDto
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.domain.model.TokenData

fun MasterResponseDto.toDomain(): MasterData {
    return MasterData(
        config = data.config,
        tokens = TokenData(
            accessToken = data.tokens.accessToken,
            refreshToken = data.tokens.refreshToken,
            accessTokenExpiry = data.tokens.accessTokenExpiry,
            refreshTokenExpiry = data.tokens.refreshTokenExpiry
        )
    )
}

fun LoginData.toDto(): LoginRequest {
    return LoginRequest(
        cert = cert,
        username = username,
        password = password,
        serial = serial
    )
}