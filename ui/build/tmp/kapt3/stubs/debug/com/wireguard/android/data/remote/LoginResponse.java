package com.wireguard.android.data.remote;

/**
 * Created by Fatih Atasever on 16.04.2024.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b<\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0011H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0011H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\tH\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\u00db\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010I\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010K\u001a\u00020\u0011H\u00d6\u0001J\t\u0010L\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001c\u00a8\u0006M"}, d2 = {"Lcom/wireguard/android/data/remote/LoginResponse;", "", "UID", "", "DeviceName", "DeviceType", "Identifier", "Email", "IgnoreGlobalSettings", "", "LastHandshakeTime", "PublicKey", "PresharedKey", "AllowedIPsStr", "AllowedIPsSrvStr", "Endpoint", "PersistentKeepalive", "", "PrivateKey", "IPsStr", "DNSStr", "Mtu", "CreatedBy", "UpdatedBy", "CreatedAt", "UpdatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAllowedIPsSrvStr", "()Ljava/lang/String;", "getAllowedIPsStr", "getCreatedAt", "getCreatedBy", "getDNSStr", "getDeviceName", "getDeviceType", "getEmail", "getEndpoint", "getIPsStr", "getIdentifier", "getIgnoreGlobalSettings", "()Z", "getLastHandshakeTime", "getMtu", "()I", "getPersistentKeepalive", "getPresharedKey", "getPrivateKey", "getPublicKey", "getUID", "getUpdatedAt", "getUpdatedBy", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ui_debug"})
public final class LoginResponse {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String UID = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String DeviceName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String DeviceType = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String Identifier = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String Email = null;
    private final boolean IgnoreGlobalSettings = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String LastHandshakeTime = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String PublicKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String PresharedKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String AllowedIPsStr = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String AllowedIPsSrvStr = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String Endpoint = null;
    private final int PersistentKeepalive = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String PrivateKey = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String IPsStr = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String DNSStr = null;
    private final int Mtu = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String CreatedBy = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String UpdatedBy = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String CreatedAt = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String UpdatedAt = null;
    
    public LoginResponse(@org.jetbrains.annotations.NotNull
    java.lang.String UID, @org.jetbrains.annotations.NotNull
    java.lang.String DeviceName, @org.jetbrains.annotations.NotNull
    java.lang.String DeviceType, @org.jetbrains.annotations.NotNull
    java.lang.String Identifier, @org.jetbrains.annotations.NotNull
    java.lang.String Email, boolean IgnoreGlobalSettings, @org.jetbrains.annotations.NotNull
    java.lang.String LastHandshakeTime, @org.jetbrains.annotations.NotNull
    java.lang.String PublicKey, @org.jetbrains.annotations.NotNull
    java.lang.String PresharedKey, @org.jetbrains.annotations.NotNull
    java.lang.String AllowedIPsStr, @org.jetbrains.annotations.NotNull
    java.lang.String AllowedIPsSrvStr, @org.jetbrains.annotations.NotNull
    java.lang.String Endpoint, int PersistentKeepalive, @org.jetbrains.annotations.NotNull
    java.lang.String PrivateKey, @org.jetbrains.annotations.NotNull
    java.lang.String IPsStr, @org.jetbrains.annotations.NotNull
    java.lang.String DNSStr, int Mtu, @org.jetbrains.annotations.NotNull
    java.lang.String CreatedBy, @org.jetbrains.annotations.NotNull
    java.lang.String UpdatedBy, @org.jetbrains.annotations.NotNull
    java.lang.String CreatedAt, @org.jetbrains.annotations.NotNull
    java.lang.String UpdatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDeviceName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDeviceType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIdentifier() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    public final boolean getIgnoreGlobalSettings() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastHandshakeTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPublicKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPresharedKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAllowedIPsStr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAllowedIPsSrvStr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEndpoint() {
        return null;
    }
    
    public final int getPersistentKeepalive() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrivateKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getIPsStr() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDNSStr() {
        return null;
    }
    
    public final int getMtu() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreatedBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUpdatedBy() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.data.remote.LoginResponse copy(@org.jetbrains.annotations.NotNull
    java.lang.String UID, @org.jetbrains.annotations.NotNull
    java.lang.String DeviceName, @org.jetbrains.annotations.NotNull
    java.lang.String DeviceType, @org.jetbrains.annotations.NotNull
    java.lang.String Identifier, @org.jetbrains.annotations.NotNull
    java.lang.String Email, boolean IgnoreGlobalSettings, @org.jetbrains.annotations.NotNull
    java.lang.String LastHandshakeTime, @org.jetbrains.annotations.NotNull
    java.lang.String PublicKey, @org.jetbrains.annotations.NotNull
    java.lang.String PresharedKey, @org.jetbrains.annotations.NotNull
    java.lang.String AllowedIPsStr, @org.jetbrains.annotations.NotNull
    java.lang.String AllowedIPsSrvStr, @org.jetbrains.annotations.NotNull
    java.lang.String Endpoint, int PersistentKeepalive, @org.jetbrains.annotations.NotNull
    java.lang.String PrivateKey, @org.jetbrains.annotations.NotNull
    java.lang.String IPsStr, @org.jetbrains.annotations.NotNull
    java.lang.String DNSStr, int Mtu, @org.jetbrains.annotations.NotNull
    java.lang.String CreatedBy, @org.jetbrains.annotations.NotNull
    java.lang.String UpdatedBy, @org.jetbrains.annotations.NotNull
    java.lang.String CreatedAt, @org.jetbrains.annotations.NotNull
    java.lang.String UpdatedAt) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}