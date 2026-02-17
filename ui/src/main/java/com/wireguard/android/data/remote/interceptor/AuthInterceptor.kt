/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.data.remote.interceptor

import android.content.Context
import android.util.Log
import com.wireguard.android.Application
import com.wireguard.android.common.Result
import com.wireguard.android.common.session.SessionManager
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.repository.AuthRepository
import com.wireguard.android.domain.usecase.get_config.GetConfigUseCase
import com.wireguard.android.domain.usecase.login.LoginUseCase
import com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent
import com.wireguard.android.presentation.manuelsetup.ManuelSetupUiState
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor() : Interceptor {

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private val sessionManager = com.wireguard.android.SessionManager()

    override fun intercept(chain: Interceptor.Chain): Response {
        if (chain.request().header("No-Auth") == "true") {
            return chain.proceed(chain.request().newBuilder()
                .removeHeader("No-Auth")
                .build())
        }
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken().let {
            requestBuilder.addHeader("Authorization", "Bearer $it")
        }

        val response = chain.proceed(requestBuilder.build())

        return if (response.code == 401) {
            response.close()

            val loginSuccess = refreshLogin()

            return if (loginSuccess) {
                val requestBuilder = chain.request().newBuilder()
                sessionManager.fetchAuthToken().let {
                    requestBuilder.addHeader("Authorization", "Bearer $it")
                }
                chain.proceed(requestBuilder.build())
            } else {
                handleLogout()
                response
            }
        } else {
            response
        }
    }


    private fun refreshLogin(): Boolean {
        return try {
            runBlocking {
                var success = false
                loginUseCase(LoginData("username", "password")).collect { result ->
                    when (result) {
                        is Result.Success -> {
                            SessionManager.saveAuthToken(result.data.token)
                            SessionManager.setLoggedIn(true)
                            success = true
                        }
                        is Result.Error -> {
                            success = false
                        }
                    }
                }
                success
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun handleLogout() {
        SessionManager.setLoggedIn(false)
    }
}