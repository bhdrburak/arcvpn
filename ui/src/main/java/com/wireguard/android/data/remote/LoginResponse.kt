/*
 * Copyright © 2017-2024 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote

/**
 * Created by Fatih Atasever on 16.04.2024.
 */
data class LoginResponse(
    val UID: String,
    val DeviceName: String,
    val DeviceType: String,
    val Identifier: String,
    val Email: String,
    val IgnoreGlobalSettings: Boolean,
    val LastHandshakeTime: String,
    val PublicKey: String,
    val PresharedKey: String,
    val AllowedIPsStr: String,
    val AllowedIPsSrvStr: String,
    val Endpoint: String,
    val PersistentKeepalive: Int,
    val PrivateKey: String,
    val IPsStr: String,
    val DNSStr: String,
    val Mtu: Int,
    val CreatedBy: String,
    val UpdatedBy: String,
    val CreatedAt: String,
    val UpdatedAt: String
)