/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.repository

import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData


interface AuthRepository {

    suspend fun getLoginMethods(): Result<LoginMethods, DataError.Network>

    suspend fun login(loginData: LoginData): Result<MasterData, DataError.Network>

    suspend fun refreshToken(): Result<MasterData, DataError.Network>

}