package com.wireguard.android.di;

import com.wireguard.android.common.network.NetworkChecker;
import com.wireguard.android.data.common.ErrorHandler;
import com.wireguard.android.data.remote.VpnAPI;
import com.wireguard.android.domain.repository.ConfigRepository;
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
public final class RepositoryModule_ProvideConfigRepositoryFactory implements Factory<ConfigRepository> {
  private final Provider<VpnAPI> apiServiceProvider;

  private final Provider<NetworkChecker> networkCheckerProvider;

  private final Provider<ErrorHandler> errorHandlerProvider;

  public RepositoryModule_ProvideConfigRepositoryFactory(Provider<VpnAPI> apiServiceProvider,
      Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.networkCheckerProvider = networkCheckerProvider;
    this.errorHandlerProvider = errorHandlerProvider;
  }

  @Override
  public ConfigRepository get() {
    return provideConfigRepository(apiServiceProvider.get(), networkCheckerProvider.get(), errorHandlerProvider.get());
  }

  public static RepositoryModule_ProvideConfigRepositoryFactory create(
      Provider<VpnAPI> apiServiceProvider, Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    return new RepositoryModule_ProvideConfigRepositoryFactory(apiServiceProvider, networkCheckerProvider, errorHandlerProvider);
  }

  public static ConfigRepository provideConfigRepository(VpnAPI apiService,
      NetworkChecker networkChecker, ErrorHandler errorHandler) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideConfigRepository(apiService, networkChecker, errorHandler));
  }
}
