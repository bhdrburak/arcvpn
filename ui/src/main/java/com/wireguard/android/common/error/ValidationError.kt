/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.error

sealed interface ValidationError: Error {

    sealed class Host : ValidationError {
        data object EMPTY : Host()
        data object INVALID_FORMAT : Host()
    }

    sealed class Port : ValidationError {
        data object EMPTY : Port()
        data object INVALID : Port()
    }

    sealed class Name : ValidationError {
        data object EMPTY : Name()
        data object TOO_SHORT : Name()
    }

    sealed class Email : ValidationError{
        data object EMPTY : Email()
        data object INVALID_FORMAT : Email()
    }

    sealed class Password : ValidationError{
        data object EMPTY : Password()
        data object  TOO_SHORT : Password()
        data object  NO_UPPERCASE : Password()
        data object  NO_DIGIT : Password()
    }

}