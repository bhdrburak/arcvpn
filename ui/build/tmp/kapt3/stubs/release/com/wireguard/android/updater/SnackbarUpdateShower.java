package com.wireguard.android.updater;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/wireguard/android/updater/SnackbarUpdateShower;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "intentLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "lastUserIntervention", "Lcom/wireguard/android/updater/Updater$Progress$NeedsUserIntervention;", "attach", "", "view", "Landroid/view/View;", "anchor", "SwapableSnackbar", "ui_release"})
public final class SnackbarUpdateShower {
    @org.jetbrains.annotations.NotNull
    private final androidx.fragment.app.Fragment fragment = null;
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.updater.Updater.Progress.NeedsUserIntervention lastUserIntervention;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> intentLauncher = null;
    
    public SnackbarUpdateShower(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
        super();
    }
    
    public final void attach(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.view.View anchor) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/wireguard/android/updater/SnackbarUpdateShower$SwapableSnackbar;", "", "fragment", "Landroidx/fragment/app/Fragment;", "view", "Landroid/view/View;", "anchor", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Landroid/view/View;)V", "actionSnackbar", "Lcom/google/android/material/snackbar/Snackbar;", "showingAction", "", "showingStatus", "statusSnackbar", "dismiss", "", "makeSnackbar", "showAction", "text", "", "action", "listener", "Landroid/view/View$OnClickListener;", "showText", "ui_release"})
    static final class SwapableSnackbar {
        @org.jetbrains.annotations.NotNull
        private final com.google.android.material.snackbar.Snackbar actionSnackbar = null;
        @org.jetbrains.annotations.NotNull
        private final com.google.android.material.snackbar.Snackbar statusSnackbar = null;
        private boolean showingAction = false;
        private boolean showingStatus = false;
        
        public SwapableSnackbar(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull
        android.view.View view, @org.jetbrains.annotations.Nullable
        android.view.View anchor) {
            super();
        }
        
        private final com.google.android.material.snackbar.Snackbar makeSnackbar(androidx.fragment.app.Fragment fragment, android.view.View view, android.view.View anchor) {
            return null;
        }
        
        public final void showAction(@org.jetbrains.annotations.NotNull
        java.lang.String text, @org.jetbrains.annotations.NotNull
        java.lang.String action, @org.jetbrains.annotations.NotNull
        android.view.View.OnClickListener listener) {
        }
        
        public final void showText(@org.jetbrains.annotations.NotNull
        java.lang.String text) {
        }
        
        public final void dismiss() {
        }
    }
}