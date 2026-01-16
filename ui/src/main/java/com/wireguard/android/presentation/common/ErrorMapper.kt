/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.presentation.common

import com.wireguard.android.R
import com.wireguard.android.common.error.DataError
import com.wireguard.android.common.error.ValidationError
import com.wireguard.android.common.error.ValidationFieldType
import javax.inject.Inject
import com.wireguard.android.common.error.Error

class ErrorMapper @Inject constructor() {

    fun mapToUiText(error: Error): UiText {
        return when (error) {
            is DataError -> mapDataError(error)
            is ValidationError -> mapValidationError(error)
            else -> UiText.DynamicString("Unknown error")
        }
    }

    private fun mapDataError(error: DataError): UiText {
        return when (error) {
            DataError.Network.NO_INTERNET -> UiText.StringResource(R.string.error_no_internet)
            DataError.Network.UNAUTHORIZED -> UiText.StringResource(R.string.error_unauthorized)
            DataError.Network.NOT_FOUND -> UiText.StringResource(R.string.error_not_found)
            DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResource(R.string.error_too_many_requests)
            DataError.Network.SERVER_ERROR -> UiText.StringResource(R.string.error_server_error)
            DataError.Network.BAD_GATEWAY -> UiText.StringResource(R.string.error_bad_gateway)
            DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(R.string.error_timeout)
            DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringResource(R.string.error_payload_too_large)
            DataError.Network.SERIALIZATION -> UiText.StringResource(R.string.error_serialization)
            DataError.Network.FORBIDDEN -> UiText.StringResource(R.string.error_forbidden)
            DataError.Network.UNKNOWN -> UiText.StringResource(R.string.error_unknown)
            //is DataError.Local -> UiText.StringResource(R.string.error_local_data)
            DataError.Domain.NO_VALID_LOGIN_METHOD -> UiText.StringResource(R.string.error_invalid_login_methods)
            DataError.Domain.EMPTY_CONFIG -> UiText.StringResource(R.string.error_empty_config)
        }
    }

    fun mapValidationErrorToField(error: ValidationError): Pair<ValidationFieldType, UiText> {
        return when (error) {
            is ValidationError.Host.EMPTY -> ValidationFieldType.HOST to UiText.StringResource(R.string.error_host_empty)
            is ValidationError.Host.INVALID_FORMAT -> ValidationFieldType.HOST to UiText.StringResource(R.string.error_host_invalid)
            is ValidationError.Port.EMPTY -> ValidationFieldType.PORT to UiText.StringResource(R.string.error_port_empty)
            is ValidationError.Port.INVALID -> ValidationFieldType.PORT to UiText.StringResource(R.string.error_port_invalid)
            is ValidationError.Name.EMPTY -> ValidationFieldType.NAME to UiText.StringResource(R.string.error_name_empty)
            is ValidationError.Name.TOO_SHORT -> ValidationFieldType.NAME to UiText.StringResource(R.string.error_name_too_short)
            is ValidationError.Email.INVALID_FORMAT -> ValidationFieldType.EMAIL to UiText.StringResource(R.string.error_email_invalid_format)
            is ValidationError.Email.EMPTY -> ValidationFieldType.EMAIL to UiText.StringResource(R.string.error_email_empty)
            is ValidationError.Password.TOO_SHORT -> ValidationFieldType.PASSWORD to UiText.StringResource(R.string.error_password_too_short)
            is ValidationError.Password.NO_DIGIT -> ValidationFieldType.PASSWORD to UiText.StringResource(R.string.error_password_too_short)
            is ValidationError.Password.NO_UPPERCASE -> ValidationFieldType.PASSWORD to UiText.StringResource(R.string.error_password_no_uppercase)
            is ValidationError.Password.EMPTY -> ValidationFieldType.PASSWORD to UiText.StringResource(R.string.error_password_empty)
        }
    }

    private fun mapValidationError(error: ValidationError): UiText {
        return mapValidationErrorToField(error)?.second ?: UiText.DynamicString("Validation error")
    }
}

