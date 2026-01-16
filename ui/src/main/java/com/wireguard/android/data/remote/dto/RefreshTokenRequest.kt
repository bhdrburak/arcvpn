/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest (@SerializedName("refreshToken") val refreshToken: String? = null)

