package com.wireguard.android.presentation.status;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0002J\u0012\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010\'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0016J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010+\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u000e\u0010/\u001a\u00020\u0014H\u0082@\u00a2\u0006\u0002\u0010\u0019R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/wireguard/android/presentation/status/StatusFragment;", "Lcom/wireguard/android/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/wireguard/android/databinding/FragmentStatusBinding;", "binding", "getBinding", "()Lcom/wireguard/android/databinding/FragmentStatusBinding;", "lastState", "", "restrictionsReceiver", "Landroid/content/BroadcastReceiver;", "getRestrictionsReceiver", "()Landroid/content/BroadcastReceiver;", "setRestrictionsReceiver", "(Landroid/content/BroadcastReceiver;)V", "timerActive", "tunnelManager", "Lcom/wireguard/android/model/TunnelManager;", "connectToTunnel", "", "tunnel", "Lcom/wireguard/android/model/ObservableTunnel;", "forceReset", "deleteEverything", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConnected", "resetEpoch", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDisconnected", "onRestrictionsChanged", "onResume", "onViewCreated", "view", "startService", "willReset", "stopService", "updateLogoutButtonVisibility", "updateStats", "ui_debug"})
public final class StatusFragment extends com.wireguard.android.presentation.common.BaseFragment {
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.databinding.FragmentStatusBinding _binding;
    private boolean timerActive = true;
    @org.jetbrains.annotations.NotNull
    private final com.wireguard.android.model.TunnelManager tunnelManager = null;
    @org.jetbrains.annotations.Nullable
    private android.content.BroadcastReceiver restrictionsReceiver;
    private boolean lastState = false;
    
    public StatusFragment() {
        super();
    }
    
    private final com.wireguard.android.databinding.FragmentStatusBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.content.BroadcastReceiver getRestrictionsReceiver() {
        return null;
    }
    
    public final void setRestrictionsReceiver(@org.jetbrains.annotations.Nullable
    android.content.BroadcastReceiver p0) {
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateLogoutButtonVisibility() {
    }
    
    private final void connectToTunnel(com.wireguard.android.model.ObservableTunnel tunnel, boolean forceReset) {
    }
    
    private final void onRestrictionsChanged() {
    }
    
    private final void onDisconnected() {
    }
    
    private final void stopService() {
    }
    
    private final void startService(boolean willReset) {
    }
    
    private final void onConnected(boolean resetEpoch) {
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
    
    private final java.lang.Object updateStats(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object deleteEverything(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}