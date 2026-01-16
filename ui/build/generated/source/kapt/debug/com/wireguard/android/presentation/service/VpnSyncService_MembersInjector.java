package com.wireguard.android.presentation.service;

import com.wireguard.android.domain.usecase.get_config.GetConfigUseCase;
import com.wireguard.android.domain.usecase.refresh_token.RefreshTokenUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class VpnSyncService_MembersInjector implements MembersInjector<VpnSyncService> {
  private final Provider<RefreshTokenUseCase> refreshTokenUseCaseProvider;

  private final Provider<GetConfigUseCase> fetchConfigUseCaseProvider;

  public VpnSyncService_MembersInjector(Provider<RefreshTokenUseCase> refreshTokenUseCaseProvider,
      Provider<GetConfigUseCase> fetchConfigUseCaseProvider) {
    this.refreshTokenUseCaseProvider = refreshTokenUseCaseProvider;
    this.fetchConfigUseCaseProvider = fetchConfigUseCaseProvider;
  }

  public static MembersInjector<VpnSyncService> create(
      Provider<RefreshTokenUseCase> refreshTokenUseCaseProvider,
      Provider<GetConfigUseCase> fetchConfigUseCaseProvider) {
    return new VpnSyncService_MembersInjector(refreshTokenUseCaseProvider, fetchConfigUseCaseProvider);
  }

  @Override
  public void injectMembers(VpnSyncService instance) {
    injectRefreshTokenUseCase(instance, refreshTokenUseCaseProvider.get());
    injectFetchConfigUseCase(instance, fetchConfigUseCaseProvider.get());
  }

  @InjectedFieldSignature("com.wireguard.android.presentation.service.VpnSyncService.refreshTokenUseCase")
  public static void injectRefreshTokenUseCase(VpnSyncService instance,
      RefreshTokenUseCase refreshTokenUseCase) {
    instance.refreshTokenUseCase = refreshTokenUseCase;
  }

  @InjectedFieldSignature("com.wireguard.android.presentation.service.VpnSyncService.fetchConfigUseCase")
  public static void injectFetchConfigUseCase(VpnSyncService instance,
      GetConfigUseCase fetchConfigUseCase) {
    instance.fetchConfigUseCase = fetchConfigUseCase;
  }
}
