package com.wireguard.android.domain.usecase.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/wireguard/android/domain/usecase/login/LoginUseCase;", "", "authRepository", "Lcom/wireguard/android/domain/repository/AuthRepository;", "(Lcom/wireguard/android/domain/repository/AuthRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/wireguard/android/common/Result;", "Lcom/wireguard/android/domain/model/MasterData;", "Lcom/wireguard/android/common/error/DataError;", "loginData", "Lcom/wireguard/android/domain/model/LoginData;", "ui_debug"})
public final class LoginUseCase {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.domain.repository.AuthRepository authRepository = null;
    
    @javax.inject.Inject
    public LoginUseCase(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.repository.AuthRepository authRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.wireguard.android.common.Result<com.wireguard.android.domain.model.MasterData, com.wireguard.android.common.error.DataError>> invoke(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.model.LoginData loginData) {
        return null;
    }
}