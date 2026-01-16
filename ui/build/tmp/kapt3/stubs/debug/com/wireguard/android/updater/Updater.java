package com.wireguard.android.updater;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0006/01234B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u001eH\u0082@\u00a2\u0006\u0002\u0010\u001fJ \u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010#\u001a\u00020\u001aH\u0082@\u00a2\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\'H\u0002J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\'J\u0006\u0010)\u001a\u00020\u001eJ\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0+2\u0006\u0010,\u001a\u00020\u0004H\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u00072\u0006\u0010.\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/wireguard/android/updater/Updater;", "", "()V", "APK_NAME_PREFIX", "", "APK_NAME_SUFFIX", "CURRENT_VERSION", "Lcom/wireguard/android/updater/Updater$Version;", "getCURRENT_VERSION", "()Lcom/wireguard/android/updater/Updater$Version;", "CURRENT_VERSION$delegate", "Lkotlin/Lazy;", "LATEST_FILE", "RELEASE_PUBLIC_KEY_BASE64", "TAG", "UPDATE_URL_FMT", "mutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/wireguard/android/updater/Updater$Progress;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "updaterScope", "Lkotlinx/coroutines/CoroutineScope;", "updating", "", "checkForUpdates", "Lcom/wireguard/android/updater/Updater$Update;", "downloadAndUpdate", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadAndUpdateWrapErrors", "emitProgress", "progress", "force", "(Lcom/wireguard/android/updater/Updater$Progress;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "installer", "context", "Landroid/content/Context;", "installerIsGooglePlay", "monitorForUpdates", "verifySignedFileList", "", "signifyDigest", "versionOfFile", "name", "AppUpdatedReceiver", "InstallReceiver", "Progress", "Sha256Digest", "Update", "Version", "ui_debug"})
public final class Updater {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "WireGuard/Updater";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String UPDATE_URL_FMT = "https://download.wireguard.com/android-client/%s";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String APK_NAME_PREFIX = "com.mobileitm.vpn.debug-";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String APK_NAME_SUFFIX = ".apk";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String LATEST_FILE = "latest.sig";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String RELEASE_PUBLIC_KEY_BASE64 = "RWTAzwGRYr3EC9px0Ia3fbttz8WcVN6wrOwWp2delz4el6SI8XmkKSMp";
    @org.jetbrains.annotations.NotNull
    private static final kotlin.Lazy CURRENT_VERSION$delegate = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.CoroutineScope updaterScope = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.MutableStateFlow<com.wireguard.android.updater.Updater.Progress> mutableState = null;
    @org.jetbrains.annotations.NotNull
    private static final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.updater.Updater.Progress> state = null;
    private static boolean updating = false;
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.updater.Updater INSTANCE = null;
    
    private Updater() {
        super();
    }
    
    private final com.wireguard.android.updater.Updater.Version getCURRENT_VERSION() {
        return null;
    }
    
    private final java.lang.String installer(android.content.Context context) {
        return null;
    }
    
    public final boolean installerIsGooglePlay(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.wireguard.android.updater.Updater.Progress> getState() {
        return null;
    }
    
    private final java.lang.Object emitProgress(com.wireguard.android.updater.Updater.Progress progress, boolean force, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.wireguard.android.updater.Updater.Version versionOfFile(java.lang.String name) {
        return null;
    }
    
    private final java.util.List<com.wireguard.android.updater.Updater.Update> verifySignedFileList(java.lang.String signifyDigest) {
        return null;
    }
    
    private final com.wireguard.android.updater.Updater.Update checkForUpdates() {
        return null;
    }
    
    private final java.lang.Object downloadAndUpdate(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object downloadAndUpdateWrapErrors(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void monitorForUpdates() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/wireguard/android/updater/Updater$AppUpdatedReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "ui_debug"})
    public static final class AppUpdatedReceiver extends android.content.BroadcastReceiver {
        
        public AppUpdatedReceiver() {
            super();
        }
        
        @java.lang.Override
        public void onReceive(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.content.Intent intent) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/wireguard/android/updater/Updater$InstallReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "ui_debug"})
    static final class InstallReceiver extends android.content.BroadcastReceiver {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String sessionId = null;
        
        public InstallReceiver() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSessionId() {
            return null;
        }
        
        @java.lang.Override
        public void onReceive(@org.jetbrains.annotations.NotNull
        android.content.Context context, @org.jetbrains.annotations.NotNull
        android.content.Intent intent) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress;", "", "()V", "Available", "Complete", "Corrupt", "Downloading", "Failure", "Installing", "NeedsUserIntervention", "Rechecking", "Lcom/wireguard/android/updater/Updater$Progress$Available;", "Lcom/wireguard/android/updater/Updater$Progress$Complete;", "Lcom/wireguard/android/updater/Updater$Progress$Corrupt;", "Lcom/wireguard/android/updater/Updater$Progress$Downloading;", "Lcom/wireguard/android/updater/Updater$Progress$Failure;", "Lcom/wireguard/android/updater/Updater$Progress$Installing;", "Lcom/wireguard/android/updater/Updater$Progress$NeedsUserIntervention;", "Lcom/wireguard/android/updater/Updater$Progress$Rechecking;", "ui_debug"})
    public static abstract class Progress {
        
        private Progress() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Available;", "Lcom/wireguard/android/updater/Updater$Progress;", "version", "", "(Ljava/lang/String;)V", "getVersion", "()Ljava/lang/String;", "update", "", "ui_debug"})
        public static final class Available extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String version = null;
            
            public Available(@org.jetbrains.annotations.NotNull
            java.lang.String version) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getVersion() {
                return null;
            }
            
            public final void update() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Complete;", "Lcom/wireguard/android/updater/Updater$Progress;", "()V", "ui_debug"})
        public static final class Complete extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            public static final com.wireguard.android.updater.Updater.Progress.Complete INSTANCE = null;
            
            private Complete() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Corrupt;", "Lcom/wireguard/android/updater/Updater$Progress;", "betterFile", "", "(Ljava/lang/String;)V", "downloadUrl", "getDownloadUrl", "()Ljava/lang/String;", "ui_debug"})
        public static final class Corrupt extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.Nullable
            private final java.lang.String betterFile = null;
            
            public Corrupt(@org.jetbrains.annotations.Nullable
            java.lang.String betterFile) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getDownloadUrl() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0019\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0004\u001a\u00020\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\n"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Downloading;", "Lcom/wireguard/android/updater/Updater$Progress;", "bytesDownloaded", "Lkotlin/ULong;", "bytesTotal", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBytesDownloaded-s-VKNKU", "()J", "J", "getBytesTotal-s-VKNKU", "ui_debug"})
        public static final class Downloading extends com.wireguard.android.updater.Updater.Progress {
            private final long bytesDownloaded = 0L;
            private final long bytesTotal = 0L;
            
            private Downloading(long bytesDownloaded, long bytesTotal) {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Failure;", "Lcom/wireguard/android/updater/Updater$Progress;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "retry", "", "ui_debug"})
        public static final class Failure extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            private final java.lang.Throwable error = null;
            
            public Failure(@org.jetbrains.annotations.NotNull
            java.lang.Throwable error) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.Throwable getError() {
                return null;
            }
            
            public final void retry() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Installing;", "Lcom/wireguard/android/updater/Updater$Progress;", "()V", "ui_debug"})
        public static final class Installing extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            public static final com.wireguard.android.updater.Updater.Progress.Installing INSTANCE = null;
            
            private Installing() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\nH\u0082@\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$NeedsUserIntervention;", "Lcom/wireguard/android/updater/Updater$Progress;", "intent", "Landroid/content/Intent;", "id", "", "(Landroid/content/Intent;I)V", "getIntent", "()Landroid/content/Intent;", "installerActive", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsDone", "", "ui_debug"})
        public static final class NeedsUserIntervention extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            private final android.content.Intent intent = null;
            private final int id = 0;
            
            public NeedsUserIntervention(@org.jetbrains.annotations.NotNull
            android.content.Intent intent, int id) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.content.Intent getIntent() {
                return null;
            }
            
            private final java.lang.Object installerActive(kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
                return null;
            }
            
            public final void markAsDone() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wireguard/android/updater/Updater$Progress$Rechecking;", "Lcom/wireguard/android/updater/Updater$Progress;", "()V", "ui_debug"})
        public static final class Rechecking extends com.wireguard.android.updater.Updater.Progress {
            @org.jetbrains.annotations.NotNull
            public static final com.wireguard.android.updater.Updater.Progress.Rechecking INSTANCE = null;
            
            private Rechecking() {
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/wireguard/android/updater/Updater$Sha256Digest;", "", "hex", "", "(Ljava/lang/String;)V", "bytes", "", "getBytes", "()[B", "ui_debug"})
    static final class Sha256Digest {
        @org.jetbrains.annotations.NotNull
        private final byte[] bytes = null;
        
        public Sha256Digest(@org.jetbrains.annotations.NotNull
        java.lang.String hex) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final byte[] getBytes() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/wireguard/android/updater/Updater$Update;", "", "fileName", "", "version", "Lcom/wireguard/android/updater/Updater$Version;", "hash", "Lcom/wireguard/android/updater/Updater$Sha256Digest;", "(Ljava/lang/String;Lcom/wireguard/android/updater/Updater$Version;Lcom/wireguard/android/updater/Updater$Sha256Digest;)V", "getFileName", "()Ljava/lang/String;", "getHash", "()Lcom/wireguard/android/updater/Updater$Sha256Digest;", "getVersion", "()Lcom/wireguard/android/updater/Updater$Version;", "ui_debug"})
    static final class Update {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String fileName = null;
        @org.jetbrains.annotations.NotNull
        private final com.wireguard.android.updater.Updater.Version version = null;
        @org.jetbrains.annotations.NotNull
        private final com.wireguard.android.updater.Updater.Sha256Digest hash = null;
        
        public Update(@org.jetbrains.annotations.NotNull
        java.lang.String fileName, @org.jetbrains.annotations.NotNull
        com.wireguard.android.updater.Updater.Version version, @org.jetbrains.annotations.NotNull
        com.wireguard.android.updater.Updater.Sha256Digest hash) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getFileName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.updater.Updater.Version getVersion() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.updater.Updater.Sha256Digest getHash() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0019\u0010\u0005\u001a\u00020\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u000e"}, d2 = {"Lcom/wireguard/android/updater/Updater$Version;", "", "version", "", "(Ljava/lang/String;)V", "parts", "Lkotlin/ULongArray;", "getParts-Y2RjT0g", "()[J", "[J", "compareTo", "", "other", "toString", "ui_debug"})
    @kotlin.OptIn(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    static final class Version implements java.lang.Comparable<com.wireguard.android.updater.Updater.Version> {
        @org.jetbrains.annotations.NotNull
        private final long[] parts = null;
        
        public Version(@org.jetbrains.annotations.NotNull
        java.lang.String version) {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
        
        @java.lang.Override
        public int compareTo(@org.jetbrains.annotations.NotNull
        com.wireguard.android.updater.Updater.Version other) {
            return 0;
        }
    }
}