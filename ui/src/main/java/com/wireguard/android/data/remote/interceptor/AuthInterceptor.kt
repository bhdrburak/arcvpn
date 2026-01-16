/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote.interceptor

import android.util.Log
import com.wireguard.android.common.session.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        SessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
            print("")
        }
        Log.d("AuthInterceptor",SessionManager.fetchAuthToken())
        return chain.proceed(requestBuilder.build())
    }
}