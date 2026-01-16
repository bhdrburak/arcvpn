/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.common

import com.wireguard.android.common.error.DataError
import com.wireguard.android.common.network.NetworkChecker
import okio.IOException
import retrofit2.HttpException
import java.net.UnknownHostException
import javax.inject.Inject


//DB işlemelri için sadece repositoryde kullanılcak hatalar reduant kod yazımını önlemk için buraya metot oalrak eklenebilir.
class ErrorHandler @Inject constructor(
    private val networkChecker: NetworkChecker
) {
    fun mapToNetworkError(e: Throwable): DataError.Network {
        return when (e) {
            is HttpException -> mapHttpCodeToError(e.code())
            is IOException -> mapIOException(e)
            else -> DataError.Network.UNKNOWN
        }
    }

    private fun mapIOException(e: IOException): DataError.Network {
        return when {
            !networkChecker.hasInternetConnection() -> DataError.Network.NO_INTERNET
            e is UnknownHostException -> DataError.Network.NOT_FOUND
            else -> DataError.Network.UNKNOWN
        }
    }

    private fun mapHttpCodeToError(code: Int): DataError.Network {
        return when (code) {
            401 -> DataError.Network.UNAUTHORIZED
            403 -> DataError.Network.FORBIDDEN
            404 -> DataError.Network.NOT_FOUND
            408 -> DataError.Network.REQUEST_TIMEOUT
            413 -> DataError.Network.PAYLOAD_TOO_LARGE
            429 -> DataError.Network.TOO_MANY_REQUESTS
            in 500..599 -> DataError.Network.SERVER_ERROR
            else -> DataError.Network.UNKNOWN
        }
    }
}