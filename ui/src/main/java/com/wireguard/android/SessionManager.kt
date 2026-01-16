/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android

class SessionManager() {

    fun saveAuthToken(token: String?) {
        if (token != null) {
            Application.getCacheManager().writeString("access_token", token)
        }
    }

    fun fetchAuthToken(): String {
        return Application.getCacheManager().readString("access_token", "")
    }

    fun saveRefreshToken(refreshToken: String?) {
        refreshToken?.let {
            Application.getCacheManager().writeString("refresh_token", it)
        }
    }

    fun fetchRefreshToken(): String {
        return Application.getCacheManager().readString("refresh_token", "")
    }

    fun clearSession() {
        Application.getCacheManager().writeString("access_token", "")
        Application.getCacheManager().writeString("refresh_token", "")
    }
}