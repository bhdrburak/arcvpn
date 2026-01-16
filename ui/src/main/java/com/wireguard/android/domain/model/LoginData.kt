/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.model

data class LoginData (val cert: String, val username: String, val password: String, val serial: String)