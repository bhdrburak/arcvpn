package com.wireguard.android.presentation.status

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wireguard.android.common.Result
import com.wireguard.android.data.remote.dto.GetConfigModel
import com.wireguard.android.domain.usecase.get_config.GetConfigUseCase
import com.wireguard.android.domain.usecase.get_node.GetNodeUseCase
import com.wireguard.android.domain.usecase.get_quick_config.GetQuickConfigUseCase
import com.wireguard.android.presentation.common.ErrorMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StatusViewModel@Inject constructor(
    private val getNodeUseCase: GetNodeUseCase,
    private val getQuickConfigUseCase: GetQuickConfigUseCase,
    private val errorMapper: ErrorMapper,
) : ViewModel() {

    private val  _uiState = MutableStateFlow<StatusUiState>(StatusUiState.Idle)
    val uiState : StateFlow<StatusUiState> = _uiState

    private val _event = MutableSharedFlow<StatusUiEvent>()
    val event: SharedFlow<StatusUiEvent> = _event


    fun getAllNodes() {

        _uiState.value = StatusUiState.Loading

        viewModelScope.launch {
            getNodeUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _uiState.value = StatusUiState.Success(result.data)
                    }

                    is Result.Error -> {
                        _uiState.value = StatusUiState.Idle
                    }
                }
            }
        }
    }


    fun getQuickConnect(nodeId: Int) {

        viewModelScope.launch {
            getQuickConfigUseCase(GetConfigModel(nodeId)).collect { result ->
                when (result) {
                    is Result.Success -> {
                        _event.emit(StatusUiEvent.NavigateToQuickConnect(result.data))
                    }

                    is Result.Error -> {
                        _event.emit(StatusUiEvent.ShowError(errorMapper.mapToUiText(result.error)))
                    }
                }
            }
        }
    }

}