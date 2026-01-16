/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.model

import com.google.gson.annotations.SerializedName
data class VpnProfile(
    val id: Int,

    @SerializedName("vpnConfiguration", alternate = ["configuration"])
    val profileName: String,

    @SerializedName("conf")
    val details: ProfileDetails,

    val isUserProfile: Boolean = false
)

data class ProfileDetails(
    @SerializedName("alwaysOnVpn")
    val alwaysOnVpn: Boolean = false,

    @SerializedName("vpnConnectionName")
    val connectionName: String?,

    @SerializedName("vpnConnectionHost")
    val host: String?,

    @SerializedName("vpnConnectionPort")
    val port: Int?,

    @SerializedName("vpnConnectionCheckTime")
    val connectionCheckTime: Int? = 60,

    @SerializedName("vpnAutoStartOnDevice")
    val autoStartOnDevice: Boolean = false,

    @SerializedName("vpnServiceBuilderAddAllowedApplication")
    val allowedApplications: List<String> = emptyList()
)

data class RawVpnProfile(
    @SerializedName("vpnConfiguration", alternate = ["configuration"])
    val profileName: String,
    @SerializedName("conf")
    val details: ProfileDetails
)



