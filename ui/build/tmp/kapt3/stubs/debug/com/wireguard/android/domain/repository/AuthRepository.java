package com.wireguard.android.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\nH\u00a6@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/wireguard/android/domain/repository/AuthRepository;", "", "getLoginMethods", "Lcom/wireguard/android/common/Result;", "Lcom/wireguard/android/domain/model/LoginMethods;", "Lcom/wireguard/android/common/error/DataError$Network;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lcom/wireguard/android/domain/model/MasterData;", "loginData", "Lcom/wireguard/android/domain/model/LoginData;", "(Lcom/wireguard/android/domain/model/LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "ui_debug"})
public abstract interface AuthRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLoginMethods(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.LoginMethods, ? extends com.wireguard.android.common.error.DataError.Network>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.model.LoginData loginData, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.MasterData, ? extends com.wireguard.android.common.error.DataError.Network>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<com.wireguard.android.domain.model.MasterData, ? extends com.wireguard.android.common.error.DataError.Network>> $completion);
}