package com.wireguard.android.common;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AndroidDeviceInfoProvider_Factory implements Factory<AndroidDeviceInfoProvider> {
  private final Provider<Context> contextProvider;

  public AndroidDeviceInfoProvider_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AndroidDeviceInfoProvider get() {
    return newInstance(contextProvider.get());
  }

  public static AndroidDeviceInfoProvider_Factory create(Provider<Context> contextProvider) {
    return new AndroidDeviceInfoProvider_Factory(contextProvider);
  }

  public static AndroidDeviceInfoProvider newInstance(Context context) {
    return new AndroidDeviceInfoProvider(context);
  }
}
