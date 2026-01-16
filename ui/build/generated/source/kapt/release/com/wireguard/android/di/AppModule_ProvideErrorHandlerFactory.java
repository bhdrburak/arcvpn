package com.wireguard.android.di;

import com.wireguard.android.common.network.NetworkChecker;
import com.wireguard.android.data.common.ErrorHandler;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideErrorHandlerFactory implements Factory<ErrorHandler> {
  private final Provider<NetworkChecker> networkCheckerProvider;

  public AppModule_ProvideErrorHandlerFactory(Provider<NetworkChecker> networkCheckerProvider) {
    this.networkCheckerProvider = networkCheckerProvider;
  }

  @Override
  public ErrorHandler get() {
    return provideErrorHandler(networkCheckerProvider.get());
  }

  public static AppModule_ProvideErrorHandlerFactory create(
      Provider<NetworkChecker> networkCheckerProvider) {
    return new AppModule_ProvideErrorHandlerFactory(networkCheckerProvider);
  }

  public static ErrorHandler provideErrorHandler(NetworkChecker networkChecker) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideErrorHandler(networkChecker));
  }
}
