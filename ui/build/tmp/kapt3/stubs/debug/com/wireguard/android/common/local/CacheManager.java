package com.wireguard.android.common.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J!\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002H\u0013\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0017J-\u0010\u0018\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00130\u001a\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J!\u0010\u001d\u001a\u00020\f\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u0002H\u0013\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0017J\u001a\u0010!\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u0001J\u0016\u0010#\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/wireguard/android/common/local/CacheManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "clearEverything", "", "successFunction", "Lkotlin/Function0;", "clearObject", "key", "", "read", "T", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "readBoolean", "", "readObject", "target", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "readString", "write", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "writeBoolean", "writeObject", "data", "writeString", "ui_debug"})
public class CacheManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    
    public CacheManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String readString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String defaultValue) {
        return null;
    }
    
    public final boolean readBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean defaultValue) {
        return false;
    }
    
    public final <T extends java.lang.Object>T read(@org.jetbrains.annotations.NotNull
    java.lang.String key, T defaultValue) {
        return null;
    }
    
    public final void writeString(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final void writeBoolean(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean value) {
    }
    
    public final <T extends java.lang.Object>void write(@org.jetbrains.annotations.NotNull
    java.lang.String key, T value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final <T extends java.lang.Object>T readObject(@org.jetbrains.annotations.Nullable
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.Class<T> target) {
        return null;
    }
    
    public final void writeObject(@org.jetbrains.annotations.Nullable
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.Object data) {
    }
    
    public final void clearObject(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    public final void clearEverything(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> successFunction) {
    }
}