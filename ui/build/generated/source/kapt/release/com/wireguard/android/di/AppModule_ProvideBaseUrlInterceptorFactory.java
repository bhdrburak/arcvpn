package com.wireguard.android.di;

import com.wireguard.android.data.remote.interceptor.BaseUrlInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideBaseUrlInterceptorFactory implements Factory<BaseUrlInterceptor> {
  @Override
  public BaseUrlInterceptor get() {
    return provideBaseUrlInterceptor();
  }

  public static AppModule_ProvideBaseUrlInterceptorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BaseUrlInterceptor provideBaseUrlInterceptor() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBaseUrlInterceptor());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideBaseUrlInterceptorFactory INSTANCE = new AppModule_ProvideBaseUrlInterceptorFactory();
  }
}
