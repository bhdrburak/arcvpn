package com.wireguard.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0096@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\nH\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/wireguard/android/data/repository/AuthRepositoryImpl;", "Lcom/wireguard/android/domain/repository/AuthRepository;", "apiService", "Lcom/wireguard/android/data/remote/VpnAPI;", "networkChecker", "Lcom/wireguard/android/common/network/NetworkChecker;", "errorHandler", "Lcom/wireguard/android/data/common/ErrorHandler;", "(Lcom/wireguard/android/data/remote/VpnAPI;Lcom/wireguard/android/common/network/NetworkChecker;Lcom/wireguard/android/data/common/ErrorHandler;)V", "getLoginMethods", "Lcom/wireguard/android/common/Result;", "Lcom/wireguard/android/domain/model/LoginMethods;", "Lcom/wireguard/android/common/error/DataError$Network;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/wireguard/android/domain/model/MasterData;", "loginData", "Lcom/wireguard/android/domain/model/LoginData;", "(Lcom/wireguard/android/domain/model/LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "ui_release"})
public final class AuthRepositoryImpl implements com.wireguard.android.domain.repository.AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.data.remote.VpnAPI apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.common.network.NetworkChecker networkChecker = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.data.common.ErrorHandler errorHandler = null;
    
    @javax.inject.Inject
    public AuthRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.VpnAPI apiService, @org.jetbrains.annotations.NotNull
    com.wireguard.android.common.network.NetworkChecker networkChecker, @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.common.ErrorHandler errorHandler) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getLoginMethods(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.LoginMethods, ? extends com.wireguard.android.common.error.DataError.Network>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object login(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.model.LoginData loginData, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.MasterData, ? extends com.wireguard.android.common.error.DataError.Network>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.MasterData, ? extends com.wireguard.android.common.error.DataError.Network>> $completion) {
        return null;
    }
}