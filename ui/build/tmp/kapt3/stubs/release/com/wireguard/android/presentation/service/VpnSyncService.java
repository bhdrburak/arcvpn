package com.wireguard.android.presentation.service;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\u0012\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0002J\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001aH\u0002J\u000e\u0010#\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010$J\u000e\u0010%\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010$J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010\'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\"\u00100\u001a\u0002012\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u00020\u001aH\u0002J\u0006\u00105\u001a\u00020\u001aJ\u001e\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0016H\u0082@\u00a2\u0006\u0002\u0010:R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/wireguard/android/presentation/service/VpnSyncService;", "Landroid/app/Service;", "()V", "fetchConfigUseCase", "Lcom/wireguard/android/domain/usecase/get_config/GetConfigUseCase;", "getFetchConfigUseCase", "()Lcom/wireguard/android/domain/usecase/get_config/GetConfigUseCase;", "setFetchConfigUseCase", "(Lcom/wireguard/android/domain/usecase/get_config/GetConfigUseCase;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "refreshTokenUseCase", "Lcom/wireguard/android/domain/usecase/refresh_token/RefreshTokenUseCase;", "getRefreshTokenUseCase", "()Lcom/wireguard/android/domain/usecase/refresh_token/RefreshTokenUseCase;", "setRefreshTokenUseCase", "(Lcom/wireguard/android/domain/usecase/refresh_token/RefreshTokenUseCase;)V", "restrictionsReceiver", "Landroid/content/BroadcastReceiver;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "checkPrivateKey", "", "inputStream", "Ljava/io/InputStream;", "checkVPNConnection", "", "willReset", "checkVpnDelayed", "connectToTunnel", "tunnel", "Lcom/wireguard/android/model/ObservableTunnel;", "forceReset", "(Lcom/wireguard/android/model/ObservableTunnel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotificationChannel", "deleteEverything", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectTunnelIfNeeded", "fetchNewConfig", "getNotification", "Landroid/app/Notification;", "logoutAndRestartApp", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "refreshToken", "stopService", "updateTunnelIfNeeded", "configText", "", "manageConfigIsChanged", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ui_release"})
public final class VpnSyncService extends android.app.Service {
    @javax.inject.Inject
    public com.wireguard.android.domain.usecase.refresh_token.RefreshTokenUseCase refreshTokenUseCase;
    @javax.inject.Inject
    public com.wireguard.android.domain.usecase.get_config.GetConfigUseCase fetchConfigUseCase;
    @org.jetbrains.annotations.NotNull
    private android.content.BroadcastReceiver restrictionsReceiver;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CompletableJob job = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.CoroutineScope scope;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ACTION_RESET = "com.wireguard.android.VpnSyncService.RESET";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ACTION_STOP = "com.wireguard.android.VpnSyncService.STOP";
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.presentation.service.VpnSyncService.Companion Companion = null;
    
    public VpnSyncService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.domain.usecase.refresh_token.RefreshTokenUseCase getRefreshTokenUseCase() {
        return null;
    }
    
    public final void setRefreshTokenUseCase(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.usecase.refresh_token.RefreshTokenUseCase p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.domain.usecase.get_config.GetConfigUseCase getFetchConfigUseCase() {
        return null;
    }
    
    public final void setFetchConfigUseCase(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.usecase.get_config.GetConfigUseCase p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
    
    private final void checkVpnDelayed(boolean willReset) {
    }
    
    private final void checkVPNConnection(boolean willReset) {
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final boolean checkPrivateKey(java.io.InputStream inputStream) {
        return false;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.DelicateCoroutinesApi.class})
    private final java.lang.Object connectToTunnel(com.wireguard.android.model.ObservableTunnel tunnel, boolean forceReset, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object deleteEverything(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void createNotificationChannel() {
    }
    
    private final android.app.Notification getNotification() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    public final void stopService() {
    }
    
    private final void logoutAndRestartApp() {
    }
    
    private final java.lang.Object disconnectTunnelIfNeeded(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void refreshToken() {
    }
    
    private final void fetchNewConfig() {
    }
    
    private final java.lang.Object updateTunnelIfNeeded(java.lang.String configText, boolean manageConfigIsChanged, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/wireguard/android/presentation/service/VpnSyncService$Companion;", "", "()V", "ACTION_RESET", "", "getACTION_RESET", "()Ljava/lang/String;", "ACTION_STOP", "getACTION_STOP", "ui_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getACTION_RESET() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getACTION_STOP() {
            return null;
        }
    }
}