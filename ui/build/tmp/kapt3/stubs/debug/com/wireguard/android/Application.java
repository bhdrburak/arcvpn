package com.wireguard.android;

@dagger.hilt.android.HiltAndroidApp
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u000e\u0010\u0018\u001a\u00020\u0004H\u0082@\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/wireguard/android/Application;", "Landroid/app/Application;", "()V", "backend", "Lcom/wireguard/android/backend/Backend;", "cacheManager", "Lcom/wireguard/android/common/local/CacheManager;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "futureBackend", "Lkotlinx/coroutines/CompletableDeferred;", "preferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "rootShell", "Lcom/wireguard/android/util/RootShell;", "toolsInstaller", "Lcom/wireguard/android/util/ToolsInstaller;", "tunnelManager", "Lcom/wireguard/android/model/TunnelManager;", "attachBaseContext", "", "context", "Landroid/content/Context;", "determineBackend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "onTerminate", "Companion", "ui_debug"})
public final class Application extends android.app.Application {
    private com.wireguard.android.common.local.CacheManager cacheManager;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CompletableDeferred<com.wireguard.android.backend.Backend> futureBackend = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope coroutineScope = null;
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.backend.Backend backend;
    private com.wireguard.android.util.RootShell rootShell;
    private androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> preferencesDataStore;
    private com.wireguard.android.util.ToolsInstaller toolsInstaller;
    private com.wireguard.android.model.TunnelManager tunnelManager;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String USER_AGENT = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "WireGuard/Application";
    private static java.lang.ref.WeakReference<com.wireguard.android.Application> weakSelf;
    public static com.wireguard.android.Application instance;
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.Application.Companion Companion = null;
    
    public Application() {
        super();
    }
    
    @java.lang.Override
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    private final java.lang.Object determineBackend(kotlin.coroutines.Continuation<? super com.wireguard.android.backend.Backend> $completion) {
        return null;
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    @java.lang.Override
    public void onTerminate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/wireguard/android/Application$Companion;", "", "()V", "TAG", "", "USER_AGENT", "getUSER_AGENT", "()Ljava/lang/String;", "instance", "Lcom/wireguard/android/Application;", "getInstance", "()Lcom/wireguard/android/Application;", "setInstance", "(Lcom/wireguard/android/Application;)V", "weakSelf", "Ljava/lang/ref/WeakReference;", "get", "getBackend", "Lcom/wireguard/android/backend/Backend;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCacheManager", "Lcom/wireguard/android/common/local/CacheManager;", "getCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getPreferencesDataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getRootShell", "Lcom/wireguard/android/util/RootShell;", "getToolsInstaller", "Lcom/wireguard/android/util/ToolsInstaller;", "getTunnelManager", "Lcom/wireguard/android/model/TunnelManager;", "ui_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getUSER_AGENT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.Application getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull
        com.wireguard.android.Application p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.Application get() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object getBackend(@org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super com.wireguard.android.backend.Backend> $completion) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.util.RootShell getRootShell() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.common.local.CacheManager getCacheManager() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getPreferencesDataStore() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.util.ToolsInstaller getToolsInstaller() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.model.TunnelManager getTunnelManager() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final kotlinx.coroutines.CoroutineScope getCoroutineScope() {
            return null;
        }
    }
}