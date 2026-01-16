package com.wireguard.android.common;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wireguard/android/common/AndroidDeviceInfoProvider;", "Lcom/wireguard/android/domain/util/DeviceInfoProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getDeviceSerial", "", "ui_debug"})
public final class AndroidDeviceInfoProvider implements com.wireguard.android.domain.util.DeviceInfoProvider {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public AndroidDeviceInfoProvider(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override
    @android.annotation.SuppressLint(value = {"HardwareIds"})
    @org.jetbrains.annotations.NotNull
    public java.lang.String getDeviceSerial() {
        return null;
    }
}