package com.wireguard.android.common.error;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u000b\u001a\u00020\bJ\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u000e\u001a\u00020\bJ2\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0013\u001a\u00020\b\u00a8\u0006\u0019"}, d2 = {"Lcom/wireguard/android/common/error/UserDataValidator;", "", "()V", "validateConnectionName", "Lcom/wireguard/android/common/Result;", "", "Lcom/wireguard/android/common/error/ValidationError$Name;", "name", "", "validateEmail", "Lcom/wireguard/android/common/error/ValidationError$Email;", "email", "validateHost", "Lcom/wireguard/android/common/error/ValidationError$Host;", "host", "validateHostSetupFields", "", "Lcom/wireguard/android/common/error/ValidationFieldType;", "Lcom/wireguard/android/common/error/ValidationError;", "port", "validatePassword", "Lcom/wireguard/android/common/error/ValidationError$Password;", "password", "validatePort", "Lcom/wireguard/android/common/error/ValidationError$Port;", "ui_debug"})
public final class UserDataValidator {
    
    public UserDataValidator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.Result<kotlin.Unit, com.wireguard.android.common.error.ValidationError.Host> validateHost(@org.jetbrains.annotations.NotNull
    java.lang.String host) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.Result<kotlin.Unit, com.wireguard.android.common.error.ValidationError.Port> validatePort(@org.jetbrains.annotations.NotNull
    java.lang.String port) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.Result<kotlin.Unit, com.wireguard.android.common.error.ValidationError.Name> validateConnectionName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.Result<kotlin.Unit, com.wireguard.android.common.error.ValidationError.Email> validateEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.common.Result<kotlin.Unit, com.wireguard.android.common.error.ValidationError.Password> validatePassword(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<com.wireguard.android.common.error.ValidationFieldType, com.wireguard.android.common.error.ValidationError> validateHostSetupFields(@org.jetbrains.annotations.NotNull
    java.lang.String host, @org.jetbrains.annotations.Nullable
    java.lang.String port, @org.jetbrains.annotations.Nullable
    java.lang.String name) {
        return null;
    }
}