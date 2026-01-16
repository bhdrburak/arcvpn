/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.model

import com.google.gson.annotations.SerializedName

class RefreshAccessTokenBody(
    @SerializedName("refreshToken")
    val refreshToken: String
){
}