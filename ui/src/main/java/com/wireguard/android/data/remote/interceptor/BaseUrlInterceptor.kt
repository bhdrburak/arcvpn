/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote.interceptor

import android.util.Log
import com.wireguard.android.Application
import com.wireguard.android.common.knobs.AdminKnobs
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseUrlInterceptor @Inject constructor(
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val rawHost = AdminKnobs.host?: throw IllegalStateException("Host ayarlanmamış. Önce kullanıcıdan alınmalı.")
        val portStr = AdminKnobs.port
        if (rawHost.isEmpty() || portStr.isEmpty()) {
            throw IllegalStateException("Host veya Port ayarlanmamış!")
        }
        val port = portStr.toInt()


        val cleanedHost = rawHost   // Agent dan https:// kısmı ile geliyor interceptörde bu durum hataya yol açıyor, https ksımını kaldırıdk.
            .replaceFirst("https://", "", ignoreCase = true)
            .replaceFirst("http://", "", ignoreCase = true)
            .trimEnd('/')


        val originalUrl = chain.request().url
        val newUrl = originalUrl.newBuilder()
            .host(cleanedHost)
            .build()

        Log.d("BaseUrlInterceptor", "Yeni URL: $newUrl")

        val newRequest = chain.request().newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(newRequest)
    }
}

