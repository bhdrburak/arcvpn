/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.repository

import android.util.Log
import com.wireguard.android.common.network.NetworkChecker
import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.data.remote.VpnAPI
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject
import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.common.session.SessionManager
import com.wireguard.android.data.common.ErrorHandler
import com.wireguard.android.data.mapper.toDomain
import com.wireguard.android.data.mapper.toDto
import com.wireguard.android.data.remote.dto.LoginRequest
import com.wireguard.android.data.remote.dto.RefreshTokenRequest
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.domain.repository.AuthRepository
import okio.IOException

// Tüm bu hataları bu katmanda map yapan bi classa al sürekli yazıp durma

class AuthRepositoryImpl @Inject constructor(
    private val apiService: VpnAPI,
    private val networkChecker: NetworkChecker,
    private val errorHandler: ErrorHandler

) : AuthRepository {
    override suspend fun getLoginMethods(): Result<LoginMethods, DataError.Network> {
        return try {
            val response = apiService.getLoginMethods()
            Result.Success(response.toDomain())
        } catch (e: Exception) {
            Result.Error(errorHandler.mapToNetworkError(e))
        }
    }

    override suspend fun login(loginData: LoginData): Result<MasterData, DataError.Network> {
        return try {
            val response = apiService.login(loginData.toDto())
            Result.Success(response.toDomain())
        } catch (e: Exception) {
            Result.Error(errorHandler.mapToNetworkError(e))
        }
    }

    override suspend fun refreshToken(): Result<MasterData, DataError.Network> {
        return try {
            val token = SessionManager.fetchRefreshToken()
            val response = apiService.refreshToken(RefreshTokenRequest(token))
            Result.Success(response.toDomain())
        } catch (e: Exception) {
            Result.Error(errorHandler.mapToNetworkError(e))
        }
    }


/*

    override suspend fun getLoginMethods(): Result<LoginMethods, DataError.Network> {
        return try {
            val response = apiService.getLoginMethods()
            val domainModel = response.toDomain()
            Result.Success(domainModel)

        } catch (e: HttpException) {
            when (e.code()) {
                401 -> Result.Error(DataError.Network.UNAUTHORIZED)
                403 -> Result.Error(DataError.Network.FORBIDDEN)
                404 -> Result.Error(DataError.Network.NOT_FOUND)
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
                500 -> Result.Error(DataError.Network.SERVER_ERROR)
                502 -> Result.Error(DataError.Network.BAD_GATEWAY)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }

        } catch (e: IOException) {
            if (e is UnknownHostException) {
                return Result.Error(DataError.Network.NOT_FOUND)
            } else if (!networkChecker.hasInternetConnection()) {
                return Result.Error(DataError.Network.NO_INTERNET)
            } else {
                return Result.Error(DataError.Network.UNKNOWN)
            }
        } catch (e: Exception) {
            Result.Error(DataError.Network.UNKNOWN)
        }
    }

    override suspend fun login(loginData: LoginData): Result<MasterData, DataError.Network> {
        return try{
            val response = apiService.login(loginData.toDto())
            Result.Success(response.toDomain())

        }
        catch (e: HttpException) {
            Log.e("LoginRepository", "HttpException: ${e.code()} - ${e.response()?.errorBody()?.string()}")
            when (e.code()) {
                401 -> Result.Error(DataError.Network.UNAUTHORIZED)
                403 -> Result.Error(DataError.Network.FORBIDDEN)
                404 -> Result.Error(DataError.Network.NOT_FOUND)
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
                500 -> Result.Error(DataError.Network.SERVER_ERROR)
                502 -> Result.Error(DataError.Network.BAD_GATEWAY)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }

        } catch (e: IOException) {
            Log.e("LoginRepository", "IOException: ${e.message}", e)

            if (e is UnknownHostException) {
                return Result.Error(DataError.Network.NOT_FOUND)
            } else if (!networkChecker.hasInternetConnection()) {
                return Result.Error(DataError.Network.NO_INTERNET)
            } else {
                return Result.Error(DataError.Network.UNKNOWN)
            }
        } catch (e: Exception) {
            Log.e("LoginRepository", "General Exception: ${e.message}", e)

            return Result.Error(DataError.Network.UNKNOWN)
        }
    }

    override suspend fun refreshToken(): Result<MasterData, DataError.Network> {
        return try {
            val refreshToken = SessionManager.fetchRefreshToken()
            val response = apiService.refreshToken(RefreshTokenRequest(refreshToken))
            Result.Success(response.toDomain())

        }
        catch (e: HttpException) {
            Log.e("LoginRepository", "HttpException: ${e.code()} - ${e.response()?.errorBody()?.string()}")
            when (e.code()) {
                401 -> Result.Error(DataError.Network.UNAUTHORIZED)
                403 -> Result.Error(DataError.Network.FORBIDDEN)
                404 -> Result.Error(DataError.Network.NOT_FOUND)
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
                429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
                500 -> Result.Error(DataError.Network.SERVER_ERROR)
                502 -> Result.Error(DataError.Network.BAD_GATEWAY)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }

        } catch (e: IOException) {
            Log.e("LoginRepository", "IOException: ${e.message}", e)

            if (e is UnknownHostException) {
                return Result.Error(DataError.Network.NOT_FOUND)
            } else if (!networkChecker.hasInternetConnection()) {
                return Result.Error(DataError.Network.NO_INTERNET)
            } else {
                return Result.Error(DataError.Network.UNKNOWN)
            }
        } catch (e: Exception) {
            Log.e("LoginRepository", "General Exception: ${e.message}", e)

            return Result.Error(DataError.Network.UNKNOWN)
        }
    }
 */

}


