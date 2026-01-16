package com.wireguard.android.domain.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/wireguard/android/domain/repository/ConfigRepository;", "", "getConfig", "Lcom/wireguard/android/common/Result;", "", "Lcom/wireguard/android/common/error/DataError$Network;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"})
public abstract interface ConfigRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getConfig(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.common.Result<java.lang.String, ? extends com.wireguard.android.common.error.DataError.Network>> $completion);
}