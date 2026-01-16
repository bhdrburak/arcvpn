package com.wireguard.android.presentation.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/wireguard/android/presentation/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "getLoginMethodsUseCase", "Lcom/wireguard/android/domain/usecase/get_login_methods/GetLoginMethodsUseCase;", "errorMapper", "Lcom/wireguard/android/presentation/common/ErrorMapper;", "(Lcom/wireguard/android/domain/usecase/get_login_methods/GetLoginMethodsUseCase;Lcom/wireguard/android/presentation/common/ErrorMapper;)V", "_event", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/wireguard/android/presentation/profile/ProfileUiEvent;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wireguard/android/presentation/profile/ProfileUiState;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onProfileSelected", "", "profile", "Lcom/wireguard/android/domain/model/VpnProfile;", "ui_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.domain.usecase.get_login_methods.GetLoginMethodsUseCase getLoginMethodsUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.presentation.common.ErrorMapper errorMapper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.wireguard.android.presentation.profile.ProfileUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.presentation.profile.ProfileUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.wireguard.android.presentation.profile.ProfileUiEvent> _event = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.wireguard.android.presentation.profile.ProfileUiEvent> event = null;
    
    @javax.inject.Inject
    public ProfileViewModel(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.usecase.get_login_methods.GetLoginMethodsUseCase getLoginMethodsUseCase, @org.jetbrains.annotations.NotNull
    com.wireguard.android.presentation.common.ErrorMapper errorMapper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.presentation.profile.ProfileUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.wireguard.android.presentation.profile.ProfileUiEvent> getEvent() {
        return null;
    }
    
    public final void onProfileSelected(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.model.VpnProfile profile) {
    }
}