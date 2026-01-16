package com.wireguard.android.presentation.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"CHANNEL_ID", "", "PING_INTERVAL", "", "getPING_INTERVAL", "()J", "setPING_INTERVAL", "(J)V", "TAG", "ui_release"})
public final class VpnSyncServiceKt {
    
    /**
     * Created by Fatih Atasever on 10.06.2024.
     */
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_ID = "VPN Service Channel";
    private static long PING_INTERVAL = 60000L;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "VpnSyncService";
    
    public static final long getPING_INTERVAL() {
        return 0L;
    }
    
    public static final void setPING_INTERVAL(long p0) {
    }
}