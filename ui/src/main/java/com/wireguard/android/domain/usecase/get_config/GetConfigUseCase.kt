/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.domain.usecase.get_config

import com.wireguard.android.common.error.DataError
import com.wireguard.android.domain.repository.ConfigRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import com.wireguard.android.common.Result
import kotlinx.coroutines.flow.flow


class GetConfigUseCase @Inject constructor(
    private val configRepository: ConfigRepository
) {
    operator fun invoke(): Flow<Result<String, DataError>> = flow {
        when (val result = configRepository.getConfig()) {
            is Result.Success -> {
                val configText = result.data
                if (configText.isBlank()) {
                    emit(Result.Error(DataError.Domain.EMPTY_CONFIG))
                } else {
                    emit(Result.Success(configText))
                }
            }
            is Result.Error -> {
                emit(Result.Error(result.error))
            }
        }
    }
}
