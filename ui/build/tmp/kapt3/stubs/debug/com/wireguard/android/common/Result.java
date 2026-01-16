package com.wireguard.android.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u000e\b\u0001\u0010\u0002 \u0001*\u00060\u0003j\u0002`\u00042\u00020\u0005:\u0002\u0006\u0007\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/wireguard/android/common/Result;", "D", "E", "Lcom/wireguard/android/common/error/Error;", "Lcom/wireguard/android/common/RootError;", "", "Error", "Success", "Lcom/wireguard/android/common/Result$Error;", "Lcom/wireguard/android/common/Result$Success;", "ui_debug"})
public abstract interface Result<D extends java.lang.Object, E extends com.wireguard.android.common.error.Error> {
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u0001*\u000e\b\u0003\u0010\u0002 \u0001*\u00060\u0003j\u0002`\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0003\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0006\u001a\u00028\u0003\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/wireguard/android/common/Result$Error;", "D", "E", "Lcom/wireguard/android/common/error/Error;", "Lcom/wireguard/android/common/RootError;", "Lcom/wireguard/android/common/Result;", "error", "(Lcom/wireguard/android/common/error/Error;)V", "getError", "()Lcom/wireguard/android/common/error/Error;", "Lcom/wireguard/android/common/error/Error;", "component1", "copy", "(Lcom/wireguard/android/common/error/Error;)Lcom/wireguard/android/common/Result$Error;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"})
    public static final class Error<D extends java.lang.Object, E extends com.wireguard.android.common.error.Error> implements com.wireguard.android.common.Result<D, E> {
        @org.jetbrains.annotations.NotNull
        private final E error = null;
        
        public Error(@org.jetbrains.annotations.NotNull
        E error) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final E getError() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final E component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.common.Result.Error<D, E> copy(@org.jetbrains.annotations.NotNull
        E error) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0002\u0010\u0001 \u0001*\u000e\b\u0003\u0010\u0002 \u0001*\u00060\u0003j\u0002`\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00028\u0002H\u00c6\u0003\u00a2\u0006\u0002\u0010\tJ$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0002H\u00c6\u0001\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0013\u0010\u0006\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/wireguard/android/common/Result$Success;", "D", "E", "Lcom/wireguard/android/common/error/Error;", "Lcom/wireguard/android/common/RootError;", "Lcom/wireguard/android/common/Result;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/wireguard/android/common/Result$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_debug"})
    public static final class Success<D extends java.lang.Object, E extends com.wireguard.android.common.error.Error> implements com.wireguard.android.common.Result<D, E> {
        private final D data = null;
        
        public Success(D data) {
            super();
        }
        
        public final D getData() {
            return null;
        }
        
        public final D component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.wireguard.android.common.Result.Success<D, E> copy(D data) {
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