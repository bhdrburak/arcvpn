/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.usecase.refresh_token

import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.model.LoginData
import com.wireguard.android.domain.model.MasterData
import com.wireguard.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
)  {
    operator  fun invoke(): Flow<Result<MasterData, DataError>> = flow {

        when(val result = authRepository.refreshToken()){

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