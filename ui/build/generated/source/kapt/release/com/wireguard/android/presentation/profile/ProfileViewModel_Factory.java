package com.wireguard.android.presentation.profile;

import com.wireguard.android.domain.usecase.get_login_methods.GetLoginMethodsUseCase;
import com.wireguard.android.presentation.common.ErrorMapper;
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
public final class ProfileViewModel_Factory implements Factory<ProfileViewModel> {
  private final Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  public ProfileViewModel_Factory(Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.getLoginMethodsUseCaseProvider = getLoginMethodsUseCaseProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public ProfileViewModel get() {
    return newInstance(getLoginMethodsUseCaseProvider.get(), errorMapperProvider.get());
  }

  public static ProfileViewModel_Factory create(
      Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new ProfileViewModel_Factory(getLoginMethodsUseCaseProvider, errorMapperProvider);
  }

  public static ProfileViewModel newInstance(GetLoginMethodsUseCase getLoginMethodsUseCase,
      ErrorMapper errorMapper) {
    return new ProfileViewModel(getLoginMethodsUseCase, errorMapper);
  }
}
