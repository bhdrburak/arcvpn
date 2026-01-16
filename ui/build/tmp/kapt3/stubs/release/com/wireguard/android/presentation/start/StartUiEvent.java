package com.wireguard.android.presentation.start;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent;", "", "NavigateToManualSetup", "NavigateToProfile", "NavigateToProfileWithData", "NavigateToStatus", "ShowError", "Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToManualSetup;", "Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToProfile;", "Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToProfileWithData;", "Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToStatus;", "Lcom/wireguard/android/presentation/start/StartUiEvent$ShowError;", "ui_release"})
public abstract interface StartUiEvent {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToManualSetup;", "Lcom/wireguard/android/presentation/start/StartUiEvent;", "loginMethods", "Lcom/wireguard/android/domain/model/LoginMethods;", "(Lcom/wireguard/android/domain/model/LoginMethods;)V", "getLoginMethods", "()Lcom/wireguard/android/domain/model/LoginMethods;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"})
    public static final class NavigateToManualSetup implements com.wireguard.android.presentation.start.StartUiEvent {
        @org.jetbrains.annotations.NotNull
        private final com.wireguard.android.domain.model.LoginMethods loginMethods = null;
        
        public NavigateToManualSetup(@org.jetbrains.annotations.NotNull
        com.wireguard.android.domain.model.LoginMethods loginMethods) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.domain.model.LoginMethods getLoginMethods() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.domain.model.LoginMethods component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.presentation.start.StartUiEvent.NavigateToManualSetup copy(@org.jetbrains.annotations.NotNull
        com.wireguard.android.domain.model.LoginMethods loginMethods) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToProfile;", "Lcom/wireguard/android/presentation/start/StartUiEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"})
    public static final class NavigateToProfile implements com.wireguard.android.presentation.start.StartUiEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.wireguard.android.presentation.start.StartUiEvent.NavigateToProfile INSTANCE = null;
        
        private NavigateToProfile() {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToProfileWithData;", "Lcom/wireguard/android/presentation/start/StartUiEvent;", "shouldFillFields", "", "(Z)V", "getShouldFillFields", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"})
    public static final class NavigateToProfileWithData implements com.wireguard.android.presentation.start.StartUiEvent {
        private final boolean shouldFillFields = false;
        
        public NavigateToProfileWithData(boolean shouldFillFields) {
            super();
        }
        
        public final boolean getShouldFillFields() {
            return false;
        }
        
        public final boolean component1() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.presentation.start.StartUiEvent.NavigateToProfileWithData copy(boolean shouldFillFields) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent$NavigateToStatus;", "Lcom/wireguard/android/presentation/start/StartUiEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"})
    public static final class NavigateToStatus implements com.wireguard.android.presentation.start.StartUiEvent {
        @org.jetbrains.annotations.NotNull
        public static final com.wireguard.android.presentation.start.StartUiEvent.NavigateToStatus INSTANCE = null;
        
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wireguard/android/presentation/start/StartUiEvent$ShowError;", "Lcom/wireguard/android/presentation/start/StartUiEvent;", "message", "Lcom/wireguard/android/presentation/common/UiText;", "(Lcom/wireguard/android/presentation/common/UiText;)V", "getMessage", "()Lcom/wireguard/android/presentation/common/UiText;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"})
    public static final class ShowError implements com.wireguard.android.presentation.start.StartUiEvent {
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
        public final com.wireguard.android.presentation.start.StartUiEvent.ShowError copy(@org.jetbrains.annotations.NotNull
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