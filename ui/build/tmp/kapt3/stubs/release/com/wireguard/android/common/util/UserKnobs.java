package com.wireguard.android.common.util;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0086@\u00a2\u0006\u0002\u0010\'J\u0018\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0086@\u00a2\u0006\u0002\u0010*J\u0018\u0010+\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u0010,J\u001c\u0010-\u001a\u00020%2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0086@\u00a2\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u0010,J\u0018\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u0010,R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00118F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00118F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0013\u00a8\u00063"}, d2 = {"Lcom/wireguard/android/common/util/UserKnobs;", "", "()V", "ALLOW_REMOTE_CONTROL_INTENTS", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "DARK_THEME", "ENABLE_KERNEL_MODULE", "LAST_USED_TUNNEL", "", "MULTIPLE_TUNNELS", "RESTORE_ON_BOOT", "RUNNING_TUNNELS", "", "UPDATER_NEWER_VERSION_CONSENTED", "UPDATER_NEWER_VERSION_SEEN", "allowRemoteControlIntents", "Lkotlinx/coroutines/flow/Flow;", "getAllowRemoteControlIntents", "()Lkotlinx/coroutines/flow/Flow;", "darkTheme", "getDarkTheme", "enableKernelModule", "getEnableKernelModule", "lastUsedTunnel", "getLastUsedTunnel", "multipleTunnels", "getMultipleTunnels", "restoreOnBoot", "getRestoreOnBoot", "runningTunnels", "getRunningTunnels", "updaterNewerVersionConsented", "getUpdaterNewerVersionConsented", "updaterNewerVersionSeen", "getUpdaterNewerVersionSeen", "setDarkTheme", "", "on", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnableKernelModule", "enable", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLastUsedTunnel", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRunningTunnels", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpdaterNewerVersionConsented", "newerVersionConsented", "setUpdaterNewerVersionSeen", "newerVersionSeen", "ui_release"})
public final class UserKnobs {
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> ENABLE_KERNEL_MODULE = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> MULTIPLE_TUNNELS = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> DARK_THEME = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> ALLOW_REMOTE_CONTROL_INTENTS = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> RESTORE_ON_BOOT = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> LAST_USED_TUNNEL = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.util.Set<java.lang.String>> RUNNING_TUNNELS = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> UPDATER_NEWER_VERSION_SEEN = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.datastore.preferences.core.Preferences.Key<java.lang.String> UPDATER_NEWER_VERSION_CONSENTED = null;
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.common.util.UserKnobs INSTANCE = null;
    
    private UserKnobs() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getEnableKernelModule() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setEnableKernelModule(@org.jetbrains.annotations.Nullable
    java.lang.Boolean enable, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getMultipleTunnels() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getDarkTheme() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setDarkTheme(boolean on, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getAllowRemoteControlIntents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Boolean> getRestoreOnBoot() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getLastUsedTunnel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLastUsedTunnel(@org.jetbrains.annotations.Nullable
    java.lang.String lastUsedTunnel, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.Set<java.lang.String>> getRunningTunnels() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setRunningTunnels(@org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> runningTunnels, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getUpdaterNewerVersionSeen() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setUpdaterNewerVersionSeen(@org.jetbrains.annotations.Nullable
    java.lang.String newerVersionSeen, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.String> getUpdaterNewerVersionConsented() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setUpdaterNewerVersionConsented(@org.jetbrains.annotations.Nullable
    java.lang.String newerVersionConsented, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}