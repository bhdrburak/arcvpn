/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote

import com.wireguard.android.data.remote.dto.LoginMethodResponseDto
import com.wireguard.android.data.remote.dto.LoginRequest
import com.wireguard.android.data.remote.dto.MasterResponseDto
import com.wireguard.android.data.remote.dto.RefreshTokenRequest
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Fatih Atasever on 16.04.2024.
 */
interface VpnAPI {

    @GET("v1/config/methods")
    suspend fun getLoginMethods(): LoginMethodResponseDto

    @POST("v1/config/token")
    suspend fun login(@Body addCertRequest: LoginRequest): MasterResponseDto

    @POST("v1/config/token/refresh")
    suspend fun refreshToken(
        @Body refreshToken: RefreshTokenRequest
    ): MasterResponseDto

    @POST("v1/config/auth")
    suspend fun getConfig() :ResponseBody
}