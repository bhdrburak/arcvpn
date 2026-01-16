package com.wireguard.android.presentation.common;

/**
 * Base class for fragments that need to know the currently-selected tunnel. Only does anything when
 * attached to a `BaseActivity`.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020-H\u0016J\u001c\u00101\u001a\u00020-2\b\u00102\u001a\u0004\u0018\u00010\u00172\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001dJ\u0018\u00108\u001a\u00020-2\u0006\u0010(\u001a\u00020\u00172\u0006\u00107\u001a\u00020\u001dH\u0004R\u001e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0084\u0004\u00a2\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010%0%0$X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R(\u0010)\u001a\u0004\u0018\u00010\u00172\b\u0010(\u001a\u0004\u0018\u00010\u00178D@DX\u0084\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001b\u00a8\u0006:"}, d2 = {"Lcom/wireguard/android/presentation/common/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/wireguard/android/activity/BaseActivity$OnSelectedTunnelChangedListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "TAG$1", "compositeDisposable", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "setCompositeDisposable", "(Lio/reactivex/rxjava3/disposables/CompositeDisposable;)V", "lastPing", "", "getLastPing", "()J", "setLastPing", "(J)V", "pendingTunnel", "Lcom/wireguard/android/model/ObservableTunnel;", "getPendingTunnel", "()Lcom/wireguard/android/model/ObservableTunnel;", "setPendingTunnel", "(Lcom/wireguard/android/model/ObservableTunnel;)V", "pendingTunnelUp", "", "getPendingTunnelUp", "()Ljava/lang/Boolean;", "setPendingTunnelUp", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "permissionActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getPermissionActivityResultLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "tunnel", "selectedTunnel", "getSelectedTunnel", "setSelectedTunnel", "onAttach", "", "context", "Landroid/content/Context;", "onDetach", "onSelectedTunnelChanged", "oldTunnel", "newTunnel", "setTunnelState", "view", "Landroid/view/View;", "checked", "setTunnelStateWithPermissionsResult", "Companion", "ui_release"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment implements com.wireguard.android.activity.BaseActivity.OnSelectedTunnelChangedListener {
    private final java.lang.String TAG$1 = null;
    @org.jetbrains.annotations.Nullable
    private io.reactivex.rxjava3.disposables.CompositeDisposable compositeDisposable;
    private long lastPing = 0L;
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.model.ObservableTunnel pendingTunnel;
    @org.jetbrains.annotations.Nullable
    private java.lang.Boolean pendingTunnelUp;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> permissionActivityResultLauncher = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "WireGuard/BaseFragment";
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.presentation.common.BaseFragment.Companion Companion = null;
    
    public BaseFragment() {
        super();
    }
    
    protected final java.lang.String getTAG() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    protected final io.reactivex.rxjava3.disposables.CompositeDisposable getCompositeDisposable() {
        return null;
    }
    
    protected final void setCompositeDisposable(@org.jetbrains.annotations.Nullable
    io.reactivex.rxjava3.disposables.CompositeDisposable p0) {
    }
    
    protected final long getLastPing() {
        return 0L;
    }
    
    protected final void setLastPing(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    protected final com.wireguard.android.model.ObservableTunnel getPendingTunnel() {
        return null;
    }
    
    protected final void setPendingTunnel(@org.jetbrains.annotations.Nullable
    com.wireguard.android.model.ObservableTunnel p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    protected final java.lang.Boolean getPendingTunnelUp() {
        return null;
    }
    
    protected final void setPendingTunnelUp(@org.jetbrains.annotations.Nullable
    java.lang.Boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    protected final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getPermissionActivityResultLauncher() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    protected final com.wireguard.android.model.ObservableTunnel getSelectedTunnel() {
        return null;
    }
    
    protected final void setSelectedTunnel(@org.jetbrains.annotations.Nullable
    com.wireguard.android.model.ObservableTunnel tunnel) {
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    public void onDetach() {
    }
    
    public final void setTunnelState(@org.jetbrains.annotations.NotNull
    android.view.View view, boolean checked) {
    }
    
    protected final void setTunnelStateWithPermissionsResult(@org.jetbrains.annotations.NotNull
    com.wireguard.android.model.ObservableTunnel tunnel, boolean checked) {
    }
    
    @java.lang.Override
    public void onSelectedTunnelChanged(@org.jetbrains.annotations.Nullable
    com.wireguard.android.model.ObservableTunnel oldTunnel, @org.jetbrains.annotations.Nullable
    com.wireguard.android.model.ObservableTunnel newTunnel) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wireguard/android/presentation/common/BaseFragment$Companion;", "", "()V", "TAG", "", "ui_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}