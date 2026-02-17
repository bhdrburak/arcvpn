/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote

import com.wireguard.android.data.remote.dto.AllNodeModel
import com.wireguard.android.data.remote.dto.GetConfigModel
import com.wireguard.android.data.remote.dto.LoginMethodResponseDto
import com.wireguard.android.data.remote.dto.LoginRequest
import com.wireguard.android.data.remote.dto.LoginResponseModel
import com.wireguard.android.data.remote.dto.MasterResponseDto
import com.wireguard.android.data.remote.dto.QuickConfig
import com.wireguard.android.data.remote.dto.RefreshTokenRequest
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Fatih Atasever on 16.04.2024.
 */
interface VpnAPI {

    @GET("api/vpn/all-nodes")
    suspend fun getNodes(): AllNodeModel

    @POST("api/login")
    suspend fun login(@Body addCertRequest: LoginRequest): LoginResponseModel

    @POST("v1/config/token/refresh")
    suspend fun refreshToken(
        @Body refreshToken: RefreshTokenRequest
    ): MasterResponseDto

    @POST("v1/config/auth")
    suspend fun getConfig() :ResponseBody


    @POST("api/vpn/quick-connect")
    suspend fun getQuickConfig(@Body getConfig: GetConfigModel) : QuickConfig
}