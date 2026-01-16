/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.usecase.login

import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
)  {
    operator  fun invoke(loginData: LoginData): Flow<Result<MasterData, DataError>> = flow {

        when(val result = authRepository.login(loginData)){

            is Result.Success -> {
                val data = result.data
                if (data.config.isBlank()) {
                    emit(Result.Error(DataError.Domain.EMPTY_CONFIG))
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
