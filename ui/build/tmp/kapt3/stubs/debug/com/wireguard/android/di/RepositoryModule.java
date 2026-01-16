package com.wireguard.android.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/wireguard/android/di/RepositoryModule;", "", "()V", "provideAuthRepository", "Lcom/wireguard/android/domain/repository/AuthRepository;", "apiService", "Lcom/wireguard/android/data/remote/VpnAPI;", "networkChecker", "Lcom/wireguard/android/common/network/NetworkChecker;", "errorHandler", "Lcom/wireguard/android/data/common/ErrorHandler;", "provideConfigRepository", "Lcom/wireguard/android/domain/repository/ConfigRepository;", "ui_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.domain.repository.AuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.VpnAPI apiService, @org.jetbrains.annotations.NotNull
    com.wireguard.android.common.network.NetworkChecker networkChecker, @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.common.ErrorHandler errorHandler) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.domain.repository.ConfigRepository provideConfigRepository(@org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.VpnAPI apiService, @org.jetbrains.annotations.NotNull
    com.wireguard.android.common.network.NetworkChecker networkChecker, @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.common.ErrorHandler errorHandler) {
        return null;
    }
}