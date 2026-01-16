package com.wireguard.android.domain.usecase.get_config;

import com.wireguard.android.domain.repository.ConfigRepository;
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
public final class GetConfigUseCase_Factory implements Factory<GetConfigUseCase> {
  private final Provider<ConfigRepository> configRepositoryProvider;

  public GetConfigUseCase_Factory(Provider<ConfigRepository> configRepositoryProvider) {
    this.configRepositoryProvider = configRepositoryProvider;
  }

  @Override
  public GetConfigUseCase get() {
    return newInstance(configRepositoryProvider.get());
  }

  public static GetConfigUseCase_Factory create(
      Provider<ConfigRepository> configRepositoryProvider) {
    return new GetConfigUseCase_Factory(configRepositoryProvider);
  }

  public static GetConfigUseCase newInstance(ConfigRepository configRepository) {
    return new GetConfigUseCase(configRepository);
  }
}
