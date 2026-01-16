package com.wireguard.android.presentation.profile;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/wireguard/android/presentation/profile/ConfigurationProfilesFragment;", "Lcom/wireguard/android/presentation/common/BaseFragment;", "()V", "_binding", "Lcom/wireguard/android/databinding/FragmentConfigurationProfilesBinding;", "adapter", "Lcom/wireguard/android/presentation/profile/ProfilesAdapter;", "binding", "getBinding", "()Lcom/wireguard/android/databinding/FragmentConfigurationProfilesBinding;", "restrictionsReceiver", "Landroid/content/BroadcastReceiver;", "viewModel", "Lcom/wireguard/android/presentation/profile/ProfileViewModel;", "getViewModel", "()Lcom/wireguard/android/presentation/profile/ProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "enableSwipeToDelete", "", "loadAndDisplayProfiles", "observeEvents", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupRecyclerView", "ui_debug"})
public final class ConfigurationProfilesFragment extends com.wireguard.android.presentation.common.BaseFragment {
    @org.jetbrains.annotations.Nullable
    private com.wireguard.android.databinding.FragmentConfigurationProfilesBinding _binding;
    private com.wireguard.android.presentation.profile.ProfilesAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private android.content.BroadcastReceiver restrictionsReceiver;
    
    public ConfigurationProfilesFragment() {
        super();
    }
    
    private final com.wireguard.android.databinding.FragmentConfigurationProfilesBinding getBinding() {
        return null;
    }
    
    private final com.wireguard.android.presentation.profile.ProfileViewModel getViewModel() {
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
    
    private final void enableSwipeToDelete() {
    }
    
    private final void loadAndDisplayProfiles() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void observeEvents() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}