/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.usecase.get_node

import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.wireguard.android.common.Result
import com.wireguard.android.data.remote.dto.AllNodeModel


class GetNodeUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(): Flow<Result<AllNodeModel, DataError>> = flow {

        when (val result = authRepository.getNodes()) {

            is Result.Success -> {
                val data = result.data

                emit(Result.Success(data))
            }

            is Result.Error -> {
                emit(Result.Error(result.error))
            }
        }
    }
}
