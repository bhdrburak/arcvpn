package com.wireguard.android.common.session;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lcom/wireguard/android/common/session/SessionManager;", "", "()V", "clearSession", "", "fetchAuthToken", "", "fetchRefreshToken", "isLoggedIn", "", "saveAuthToken", "token", "saveRefreshToken", "refreshToken", "setLoggedIn", "loggedIn", "ui_release"})
public final class SessionManager {
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.common.session.SessionManager INSTANCE = null;
    
    private SessionManager() {
        super();
    }
    
    public final void saveAuthToken(@org.jetbrains.annotations.Nullable
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fetchAuthToken() {
        return null;
    }
    
    public final void saveRefreshToken(@org.jetbrains.annotations.Nullable
    java.lang.String refreshToken) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String fetchRefreshToken() {
        return null;
    }
    
    public final void setLoggedIn(boolean loggedIn) {
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final void clearSession() {
    }
}