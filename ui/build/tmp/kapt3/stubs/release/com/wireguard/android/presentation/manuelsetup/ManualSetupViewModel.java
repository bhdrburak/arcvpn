package com.wireguard.android.presentation.manuelsetup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0016J&\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/wireguard/android/presentation/manuelsetup/ManualSetupViewModel;", "Landroidx/lifecycle/ViewModel;", "loginUseCase", "Lcom/wireguard/android/domain/usecase/login/LoginUseCase;", "errorMapper", "Lcom/wireguard/android/presentation/common/ErrorMapper;", "userDataValidator", "Lcom/wireguard/android/common/error/UserDataValidator;", "deviceInfoProvider", "Lcom/wireguard/android/domain/util/DeviceInfoProvider;", "(Lcom/wireguard/android/domain/usecase/login/LoginUseCase;Lcom/wireguard/android/presentation/common/ErrorMapper;Lcom/wireguard/android/common/error/UserDataValidator;Lcom/wireguard/android/domain/util/DeviceInfoProvider;)V", "_event", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiState;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "<set-?>", "Ljava/security/cert/X509Certificate;", "selectedCertificate", "getSelectedCertificate", "()Ljava/security/cert/X509Certificate;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "login", "", "username", "", "password", "cert", "onCertificateSelected", "onLoginClicked", "requireCredential", "", "requireCert", "ui_release"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ManualSetupViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.domain.usecase.login.LoginUseCase loginUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.presentation.common.ErrorMapper errorMapper = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.common.error.UserDataValidator userDataValidator = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.domain.util.DeviceInfoProvider deviceInfoProvider = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiState> uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent> _event = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent> event = null;
    @org.jetbrains.annotations.Nullable
    private java.security.cert.X509Certificate selectedCertificate;
    
    @javax.inject.Inject
    public ManualSetupViewModel(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.usecase.login.LoginUseCase loginUseCase, @org.jetbrains.annotations.NotNull
    com.wireguard.android.presentation.common.ErrorMapper errorMapper, @org.jetbrains.annotations.NotNull
    com.wireguard.android.common.error.UserDataValidator userDataValidator, @org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.util.DeviceInfoProvider deviceInfoProvider) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent> getEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.security.cert.X509Certificate getSelectedCertificate() {
        return null;
    }
    
    public final void onCertificateSelected(@org.jetbrains.annotations.NotNull
    java.security.cert.X509Certificate cert) {
    }
    
    private final void login(java.lang.String username, java.lang.String password, java.lang.String cert) {
    }
    
    public final void onLoginClicked(@org.jetbrains.annotations.NotNull
    java.lang.String username, @org.jetbrains.annotations.NotNull
    java.lang.String password, boolean requireCredential, boolean requireCert) {
    }
}