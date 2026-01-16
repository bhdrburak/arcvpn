/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.model

import com.google.gson.annotations.SerializedName

data class Tokens(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("access_tokenExpiry")
    val accessTokenExpiry: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("refresh_token_expiry")
    val refreshTokenExpiry: String
)