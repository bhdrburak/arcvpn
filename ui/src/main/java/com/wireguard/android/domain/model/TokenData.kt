/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.model

data class TokenData(
    val accessToken: String?,
    val accessTokenExpiry: String?,
    val refreshToken: String?,
    val refreshTokenExpiry: String?
)