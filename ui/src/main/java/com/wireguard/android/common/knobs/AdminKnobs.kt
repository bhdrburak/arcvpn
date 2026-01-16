/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.knobs

import com.wireguard.android.Application
import com.wireguard.android.domain.model.ProfileDetails

private const val DEFAULT_CONNECTION_NAME = "Arc VPN"
const val DEFAULT_ALWAYS_ON_CONNECTION = false
object AdminKnobs {
    private fun getActiveDetails(): ProfileDetails? {
        return ProfileManager.getActiveProfile()?.details
    }

    val privateKey: String
        get() = Application.getCacheManager()
            .readString("privateKey", "")

    val connectionName: String
        get() = getActiveDetails()?.connectionName ?: DEFAULT_CONNECTION_NAME

    val host: String
        get() = getActiveDetails()?.host ?: ""

    val port: String
        get() = getActiveDetails()?.port?.toString() ?: ""

    val alwaysOnConnection: Boolean
        get() = getActiveDetails()?.alwaysOnVpn ?: false

    val connectionTime: String
        get() = getActiveDetails()?.connectionCheckTime?.toString() ?: "60"


    fun getAllowedPackageList(): List<String> {
        return getActiveDetails()?.allowedApplications ?: emptyList()
    }
}
