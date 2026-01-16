package com.wireguard.android.common.knobs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/wireguard/android/common/knobs/AdminKnobs;", "", "()V", "alwaysOnConnection", "", "getAlwaysOnConnection", "()Z", "connectionName", "", "getConnectionName", "()Ljava/lang/String;", "connectionTime", "getConnectionTime", "host", "getHost", "port", "getPort", "privateKey", "getPrivateKey", "getActiveDetails", "Lcom/wireguard/android/domain/model/ProfileDetails;", "getAllowedPackageList", "", "ui_release"})
public final class AdminKnobs {
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.common.knobs.AdminKnobs INSTANCE = null;
    
    private AdminKnobs() {
        super();
    }
    
    private final com.wireguard.android.domain.model.ProfileDetails getActiveDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrivateKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConnectionName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getHost() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPort() {
        return null;
    }
    
    public final boolean getAlwaysOnConnection() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConnectionTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getAllowedPackageList() {
        return null;
    }
}