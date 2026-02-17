/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.repository

import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.data.remote.dto.AllNodeModel
import com.wireguard.android.data.remote.dto.GetConfigModel
import com.wireguard.android.data.remote.dto.LoginResponseModel
import com.wireguard.android.data.remote.dto.QuickConfig
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData


interface AuthRepository {

    suspend fun getNodes(): Result<AllNodeModel, DataError.Network>

    suspend fun login(loginData: LoginData): Result<LoginResponseModel, DataError.Network>

    suspend fun refreshToken(): Result<MasterData, DataError.Network>

    suspend fun getQuickConnect(getConfigModel: GetConfigModel): Result<QuickConfig, DataError.Network>

}