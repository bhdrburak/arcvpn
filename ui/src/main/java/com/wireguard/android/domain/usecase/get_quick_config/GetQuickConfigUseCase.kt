package com.wireguard.android.domain.usecase.get_quick_config

import com.wireguard.android.common.Result
import com.wireguard.android.common.error.DataError
import com.wireguard.android.data.remote.dto.GetConfigModel
import com.wireguard.android.data.remote.dto.QuickConfig
import com.wireguard.android.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetQuickConfigUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(getConfigModel: GetConfigModel): Flow<Result<QuickConfig, DataError>> = flow {
        when (val result = authRepository.getQuickConnect(getConfigModel)) {
            is Result.Success -> {
                emit(Result.Success(result.data))
            }
            is Result.Error -> {
                emit(Result.Error(result.error))
            }
        }
    }
}