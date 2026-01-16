package com.wireguard.android.common.error;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/wireguard/android/common/error/DataError;", "Lcom/wireguard/android/common/error/Error;", "Domain", "Local", "Network", "Lcom/wireguard/android/common/error/DataError$Domain;", "Lcom/wireguard/android/common/error/DataError$Local;", "Lcom/wireguard/android/common/error/DataError$Network;", "ui_release"})
public abstract interface DataError extends com.wireguard.android.common.error.Error {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wireguard/android/common/error/DataError$Domain;", "", "Lcom/wireguard/android/common/error/DataError;", "(Ljava/lang/String;I)V", "NO_VALID_LOGIN_METHOD", "EMPTY_CONFIG", "ui_release"})
    public static enum Domain implements com.wireguard.android.common.error.DataError {
        /*public static final*/ NO_VALID_LOGIN_METHOD /* = new NO_VALID_LOGIN_METHOD() */,
        /*public static final*/ EMPTY_CONFIG /* = new EMPTY_CONFIG() */;
        
        Domain() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.wireguard.android.common.error.DataError.Domain> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/wireguard/android/common/error/DataError$Local;", "", "Lcom/wireguard/android/common/error/DataError;", "(Ljava/lang/String;I)V", "ui_release"})
    public static enum Local implements com.wireguard.android.common.error.DataError {
;
        
        Local() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.wireguard.android.common.error.DataError.Local> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/wireguard/android/common/error/DataError$Network;", "", "Lcom/wireguard/android/common/error/DataError;", "(Ljava/lang/String;I)V", "REQUEST_TIMEOUT", "TOO_MANY_REQUESTS", "NO_INTERNET", "PAYLOAD_TOO_LARGE", "SERVER_ERROR", "SERIALIZATION", "UNAUTHORIZED", "FORBIDDEN", "NOT_FOUND", "BAD_GATEWAY", "UNKNOWN", "ui_release"})
    public static enum Network implements com.wireguard.android.common.error.DataError {
        /*public static final*/ REQUEST_TIMEOUT /* = new REQUEST_TIMEOUT() */,
        /*public static final*/ TOO_MANY_REQUESTS /* = new TOO_MANY_REQUESTS() */,
        /*public static final*/ NO_INTERNET /* = new NO_INTERNET() */,
        /*public static final*/ PAYLOAD_TOO_LARGE /* = new PAYLOAD_TOO_LARGE() */,
        /*public static final*/ SERVER_ERROR /* = new SERVER_ERROR() */,
        /*public static final*/ SERIALIZATION /* = new SERIALIZATION() */,
        /*public static final*/ UNAUTHORIZED /* = new UNAUTHORIZED() */,
        /*public static final*/ FORBIDDEN /* = new FORBIDDEN() */,
        /*public static final*/ NOT_FOUND /* = new NOT_FOUND() */,
        /*public static final*/ BAD_GATEWAY /* = new BAD_GATEWAY() */,
        /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
        
        Network() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.wireguard.android.common.error.DataError.Network> getEntries() {
            return null;
        }
    }
}