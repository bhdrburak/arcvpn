package com.wireguard.android.presentation.manuelsetup;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent;", "", "NavigateToHostSetup", "NavigateToStatus", "ShowError", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$NavigateToHostSetup;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$NavigateToStatus;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$ShowError;", "ui_debug"})
public abstract interface ManuelSetupUiEvent {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$NavigateToHostSetup;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"})
    public static final class NavigateToHostSetup implements com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent.NavigateToHostSetup INSTANCE = null;
        
        private NavigateToHostSetup() {
            super();
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$NavigateToStatus;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"})
    public static final class NavigateToStatus implements com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent.NavigateToStatus INSTANCE = null;
        
        private NavigateToStatus() {
            super();
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent$ShowError;", "Lcom/wireguard/android/presentation/manuelsetup/ManuelSetupUiEvent;", "message", "Lcom/wireguard/android/presentation/common/UiText;", "(Lcom/wireguard/android/presentation/common/UiText;)V", "getMessage", "()Lcom/wireguard/android/presentation/common/UiText;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"})
    public static final class ShowError implements com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent {
        @org.jetbrains.annotations.NotNull
        private final com.wireguard.android.presentation.common.UiText message = null;
        
        public ShowError(@org.jetbrains.annotations.NotNull
        com.wireguard.android.presentation.common.UiText message) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.presentation.common.UiText getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.presentation.common.UiText component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.presentation.manuelsetup.ManuelSetupUiEvent.ShowError copy(@org.jetbrains.annotations.NotNull
        com.wireguard.android.presentation.common.UiText message) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}