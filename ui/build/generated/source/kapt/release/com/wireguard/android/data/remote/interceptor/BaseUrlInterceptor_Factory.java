package com.wireguard.android.data.remote.interceptor;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class BaseUrlInterceptor_Factory implements Factory<BaseUrlInterceptor> {
  @Override
  public BaseUrlInterceptor get() {
    return newInstance();
  }

  public static BaseUrlInterceptor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BaseUrlInterceptor newInstance() {
    return new BaseUrlInterceptor();
  }

  private static final class InstanceHolder {
    private static final BaseUrlInterceptor_Factory INSTANCE = new BaseUrlInterceptor_Factory();
  }
}
