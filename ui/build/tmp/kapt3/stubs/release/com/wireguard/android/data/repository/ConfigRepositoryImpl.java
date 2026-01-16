package com.wireguard.android.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0096@\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/wireguard/android/data/repository/ConfigRepositoryImpl;", "Lcom/wireguard/android/domain/repository/ConfigRepository;", "apiService", "Lcom/wireguard/android/data/remote/VpnAPI;", "networkChecker", "Lcom/wireguard/android/common/network/NetworkChecker;", "errorHandler", "Lcom/wireguard/android/data/common/ErrorHandler;", "(Lcom/wireguard/android/data/remote/VpnAPI;Lcom/wireguard/android/common/network/NetworkChecker;Lcom/wireguard/android/data/common/ErrorHandler;)V", "getConfig", "Lcom/wireguard/android/common/Result;", "", "Lcom/wireguard/android/common/error/DataError$Network;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"})
public final class ConfigRepositoryImpl implements com.wireguard.android.domain.repository.ConfigRepository {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.data.remote.VpnAPI apiService = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.common.network.NetworkChecker networkChecker = null;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.data.common.ErrorHandler errorHandler = null;
    
    @javax.inject.Inject
    public ConfigRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.VpnAPI apiService, @org.jetbrains.annotations.NotNull
    com.wireguard.android.common.network.NetworkChecker networkChecker, @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.common.ErrorHandler errorHandler) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getConfig(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<java.lang.String, ? extends com.wireguard.android.common.error.DataError.Network>> $completion) {
        return null;
    }
}