package com.wireguard.android.data.remote;

/**
 * Created by Fatih Atasever on 16.04.2024.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/wireguard/android/data/remote/VpnAPI;", "", "getConfig", "Lokhttp3/ResponseBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLoginMethods", "Lcom/wireguard/android/data/remote/dto/LoginMethodResponseDto;", "login", "Lcom/wireguard/android/data/remote/dto/MasterResponseDto;", "addCertRequest", "Lcom/wireguard/android/data/remote/dto/LoginRequest;", "(Lcom/wireguard/android/data/remote/dto/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "Lcom/wireguard/android/data/remote/dto/RefreshTokenRequest;", "(Lcom/wireguard/android/data/remote/dto/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"})
public abstract interface VpnAPI {
    
    @retrofit2.http.GET(value = "v1/config/methods")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getLoginMethods(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.data.remote.dto.LoginMethodResponseDto> $completion);
    
    @retrofit2.http.POST(value = "v1/config/token")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.dto.LoginRequest addCertRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.data.remote.dto.MasterResponseDto> $completion);
    
    @retrofit2.http.POST(value = "v1/config/token/refresh")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object refreshToken(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.wireguard.android.data.remote.dto.RefreshTokenRequest refreshToken, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.wireguard.android.data.remote.dto.MasterResponseDto> $completion);
    
    @retrofit2.http.POST(value = "v1/config/auth")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getConfig(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> $completion);
}