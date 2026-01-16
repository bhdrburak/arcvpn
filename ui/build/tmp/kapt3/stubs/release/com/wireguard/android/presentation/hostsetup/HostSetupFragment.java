package com.wireguard.android.presentation.hostsetup;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u001a\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010#\u001a\u00020\u00152\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\'0%H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006)"}, d2 = {"Lcom/wireguard/android/presentation/hostsetup/HostSetupFragment;", "Lcom/wireguard/android/presentation/common/BaseLoginFragment;", "()V", "_binding", "Lcom/wireguard/android/databinding/FragmentHostSetupBinding;", "binding", "getBinding", "()Lcom/wireguard/android/databinding/FragmentHostSetupBinding;", "errorMapper", "Lcom/wireguard/android/presentation/common/ErrorMapper;", "getErrorMapper", "()Lcom/wireguard/android/presentation/common/ErrorMapper;", "setErrorMapper", "(Lcom/wireguard/android/presentation/common/ErrorMapper;)V", "userDataValidator", "Lcom/wireguard/android/common/error/UserDataValidator;", "getUserDataValidator", "()Lcom/wireguard/android/common/error/UserDataValidator;", "setUserDataValidator", "(Lcom/wireguard/android/common/error/UserDataValidator;)V", "checkContinueButton", "", "clearFieldErrors", "navigateToProfile", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showValidationErrors", "errors", "", "Lcom/wireguard/android/common/error/ValidationFieldType;", "Lcom/wireguard/android/presentation/common/UiText;", "triggerSave", "ui_release"})
public final class HostSetupFragment extends com.wireguard.android.presentation.common.BaseLoginFragment {
    @javax.inject.Inject
    public com.wireguard.android.presentation.common.ErrorMapper errorMapper;
    @javax.inject.Inject
    public com.wireguard.android.common.error.UserDataValidator userDataValidator;
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.databinding.FragmentHostSetupBinding _binding;
    
    public HostSetupFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.presentation.common.ErrorMapper getErrorMapper() {
        return null;
    }
    
    public final void setErrorMapper(@org.jetbrains.annotations.NotNull
    com.wireguard.android.presentation.common.ErrorMapper p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.error.UserDataValidator getUserDataValidator() {
        return null;
    }
    
    public final void setUserDataValidator(@org.jetbrains.annotations.NotNull
    com.wireguard.android.common.error.UserDataValidator p0) {
    }
    
    private final com.wireguard.android.databinding.FragmentHostSetupBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
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
    
    private final void triggerSave() {
    }
    
    private final void navigateToProfile() {
    }
    
    private final void checkContinueButton() {
    }
    
    private final void clearFieldErrors() {
    }
    
    private final void showValidationErrors(java.util.Map<com.wireguard.android.common.error.ValidationFieldType, ? extends com.wireguard.android.presentation.common.UiText> errors) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}