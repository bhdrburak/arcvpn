/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.repository

import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError

interface ConfigRepository {

    suspend fun getConfig(): Result<String, DataError.Network>

}