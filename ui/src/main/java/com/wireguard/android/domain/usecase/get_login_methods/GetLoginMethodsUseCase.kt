/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.usecase.get_login_methods

import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.model.LoginMethods
import com.wireguard.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.wireguard.android.common.Result


class GetLoginMethodsUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Result<LoginMethods, DataError>> = flow {

        when (val result = authRepository.getLoginMethods()) {

            is Result.Success -> {
                val data = result.data

                if (!data.certification && !data.credential && !data.validDevice) {
                    emit(Result.Error(DataError.Domain.NO_VALID_LOGIN_METHOD))
                } else {
                    emit(Result.Success(data))
                }
            }

            is Result.Error -> {
                emit(Result.Error(result.error))
            }
        }
    }
}
