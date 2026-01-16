package com.wireguard.android.data.repository;

import com.wireguard.android.common.network.NetworkChecker;
import com.wireguard.android.data.common.ErrorHandler;
import com.wireguard.android.data.remote.VpnAPI;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ConfigRepositoryImpl_Factory implements Factory<ConfigRepositoryImpl> {
  private final Provider<VpnAPI> apiServiceProvider;

  private final Provider<NetworkChecker> networkCheckerProvider;

  private final Provider<ErrorHandler> errorHandlerProvider;

  public ConfigRepositoryImpl_Factory(Provider<VpnAPI> apiServiceProvider,
      Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.networkCheckerProvider = networkCheckerProvider;
    this.errorHandlerProvider = errorHandlerProvider;
  }

  @Override
  public ConfigRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), networkCheckerProvider.get(), errorHandlerProvider.get());
  }

  public static ConfigRepositoryImpl_Factory create(Provider<VpnAPI> apiServiceProvider,
      Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    return new ConfigRepositoryImpl_Factory(apiServiceProvider, networkCheckerProvider, errorHandlerProvider);
  }

  public static ConfigRepositoryImpl newInstance(VpnAPI apiService, NetworkChecker networkChecker,
      ErrorHandler errorHandler) {
    return new ConfigRepositoryImpl(apiService, networkChecker, errorHandler);
  }
}
