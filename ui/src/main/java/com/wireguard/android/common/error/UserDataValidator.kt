/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.error
import com.wireguard.android.common.Result

class UserDataValidator {

    fun validateHost(host: String): Result<Unit, ValidationError.Host> {
        if (host.isBlank()) {
            return Result.Error(ValidationError.Host.EMPTY)
        }

        //val regex = Regex("^[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") // örn: myvpn.mycompany.com
        /*val regex = Regex("^[a-zA-Z0-9-]+\\.[a-zA-Z0-9-]+\\.com$")
        if (!regex.matches(host)) {
            return Result.Error(ValidationError.Host.INVALID_FORMAT)
        }*/

        return Result.Success(Unit)
    }

    fun validatePort(port: String): Result<Unit, ValidationError.Port> {
        if (port.isBlank()) {
            return Result.Error(ValidationError.Port.EMPTY)
        }

        /*val portNumber = port.toIntOrNull()
        if (portNumber == null || portNumber !in 1..65535) {
            return Result.Error(ValidationError.Port.INVALID)
        }*/

        return Result.Success(Unit)
    }

    fun validateConnectionName(name: String): Result<Unit, ValidationError.Name> {
        if (name.isBlank()) {
            return Result.Error(ValidationError.Name.EMPTY)
        }

        /*if (name.length < 3) {
            return Result.Error(ValidationError.Name.TOO_SHORT)
        }*/

        return Result.Success(Unit)
    }

    fun validateEmail(email: String): Result<Unit, ValidationError.Email> {
        if (email.isBlank()) return Result.Error(ValidationError.Email.EMPTY)

        //val regex = Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")
        /*val regex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (!regex.matches(email)) return Result.Error(ValidationError.Email.INVALID_FORMAT)*/

        return Result.Success(Unit)
    }

    fun validatePassword(password: String): Result<Unit, ValidationError.Password> {
        if (password.length < 9) return Result.Error(ValidationError.Password.TOO_SHORT)

        /*val hasUppercase = password.any { it.isUpperCase() }
        if (!hasUppercase) return Result.Error(ValidationError.Password.NO_UPPERCASE)

        val hasDigit = password.any { it.isDigit() }
        if (!hasDigit) return Result.Error(ValidationError.Password.NO_DIGIT)*/

        return Result.Success(Unit)
    }


    fun validateHostSetupFields(
        host: String,
        port: String? = null,
        name: String? = null
    ): Map<ValidationFieldType, ValidationError> {
        val errors = mutableMapOf<ValidationFieldType, ValidationError>()

        // HOST
        when (val result = validateHost(host)) {
            is Result.Error -> errors[ValidationFieldType.HOST] = result.error
            else -> {}
        }

        // PORT (isteğe bağlı alan)
        if (port != null) {
            when (val result = validatePort(port)) {
                is Result.Error -> errors[ValidationFieldType.PORT] = result.error
                else -> {}
            }
        }

        // NAME (isteğe bağlı alan)
        if (name != null) {
            when (val result = validateConnectionName(name)) {
                is Result.Error -> errors[ValidationFieldType.NAME] = result.error
                else -> {}
            }
        }

        return errors
    }

}