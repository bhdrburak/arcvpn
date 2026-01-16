/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("cert") val cert: String? = null,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("serial") val serial: String
)