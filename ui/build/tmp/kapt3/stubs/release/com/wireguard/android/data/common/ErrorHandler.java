package com.wireguard.android.data.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/wireguard/android/data/common/ErrorHandler;", "", "networkChecker", "Lcom/wireguard/android/common/network/NetworkChecker;", "(Lcom/wireguard/android/common/network/NetworkChecker;)V", "mapHttpCodeToError", "Lcom/wireguard/android/common/error/DataError$Network;", "code", "", "mapIOException", "e", "Ljava/io/IOException;", "Lokio/IOException;", "mapToNetworkError", "", "ui_release"})
public final class ErrorHandler {
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.common.network.NetworkChecker networkChecker = null;
    
    @javax.inject.Inject
    public ErrorHandler(@org.jetbrains.annotations.NotNull
    com.wireguard.android.common.network.NetworkChecker networkChecker) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.error.DataError.Network mapToNetworkError(@org.jetbrains.annotations.NotNull
    java.lang.Throwable e) {
        return null;
    }
    
    private final com.wireguard.android.common.error.DataError.Network mapIOException(java.io.IOException e) {
        return null;
    }
    
    private final com.wireguard.android.common.error.DataError.Network mapHttpCodeToError(int code) {
        return null;
    }
}