package com.wireguard.android.di;

import com.wireguard.android.common.network.NetworkChecker;
import com.wireguard.android.data.common.ErrorHandler;
import com.wireguard.android.data.remote.VpnAPI;
import com.wireguard.android.domain.repository.AuthRepository;
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
public final class RepositoryModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<VpnAPI> apiServiceProvider;

  private final Provider<NetworkChecker> networkCheckerProvider;

  private final Provider<ErrorHandler> errorHandlerProvider;

  public RepositoryModule_ProvideAuthRepositoryFactory(Provider<VpnAPI> apiServiceProvider,
      Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.networkCheckerProvider = networkCheckerProvider;
    this.errorHandlerProvider = errorHandlerProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(apiServiceProvider.get(), networkCheckerProvider.get(), errorHandlerProvider.get());
  }

  public static RepositoryModule_ProvideAuthRepositoryFactory create(
      Provider<VpnAPI> apiServiceProvider, Provider<NetworkChecker> networkCheckerProvider,
      Provider<ErrorHandler> errorHandlerProvider) {
    return new RepositoryModule_ProvideAuthRepositoryFactory(apiServiceProvider, networkCheckerProvider, errorHandlerProvider);
  }

  public static AuthRepository provideAuthRepository(VpnAPI apiService,
      NetworkChecker networkChecker, ErrorHandler errorHandler) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideAuthRepository(apiService, networkChecker, errorHandler));
  }
}
