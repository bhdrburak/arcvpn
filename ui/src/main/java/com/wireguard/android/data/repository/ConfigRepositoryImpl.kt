/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.repository

import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.common.network.NetworkChecker
import com.wireguard.android.data.common.ErrorHandler
import com.wireguard.android.data.remote.VpnAPI
import com.wireguard.android.domain.repository.ConfigRepository
import javax.inject.Inject


class ConfigRepositoryImpl @Inject constructor(
    private val apiService: VpnAPI,
    private val networkChecker: NetworkChecker,
    private  val errorHandler: ErrorHandler

) : ConfigRepository {
    override suspend fun getConfig(): Result<String, DataError.Network> {
        return try {
            val response = apiService.getConfig()
            val configText = response.string()
            Result.Success(configText)
        }
        catch (e:Exception){
            Result.Error(errorHandler.mapToNetworkError(e))
        }
    }

}