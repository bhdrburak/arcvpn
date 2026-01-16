package com.wireguard.android.di;

import com.wireguard.android.data.remote.interceptor.AuthInterceptor;
import com.wireguard.android.data.remote.interceptor.BaseUrlInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<BaseUrlInterceptor> baseUrlInterceptorProvider;

  private final Provider<AuthInterceptor> authInterceptorProvider;

  public AppModule_ProvideOkHttpClientFactory(
      Provider<BaseUrlInterceptor> baseUrlInterceptorProvider,
      Provider<AuthInterceptor> authInterceptorProvider) {
    this.baseUrlInterceptorProvider = baseUrlInterceptorProvider;
    this.authInterceptorProvider = authInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(baseUrlInterceptorProvider.get(), authInterceptorProvider.get());
  }

  public static AppModule_ProvideOkHttpClientFactory create(
      Provider<BaseUrlInterceptor> baseUrlInterceptorProvider,
      Provider<AuthInterceptor> authInterceptorProvider) {
    return new AppModule_ProvideOkHttpClientFactory(baseUrlInterceptorProvider, authInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(BaseUrlInterceptor baseUrlInterceptor,
      AuthInterceptor authInterceptor) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOkHttpClient(baseUrlInterceptor, authInterceptor));
  }
}
