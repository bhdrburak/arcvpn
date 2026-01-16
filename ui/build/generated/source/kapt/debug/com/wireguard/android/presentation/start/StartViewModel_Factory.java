package com.wireguard.android.presentation.start;

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
public final class StartViewModel_Factory implements Factory<StartViewModel> {
  private final Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  public StartViewModel_Factory(Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    this.getLoginMethodsUseCaseProvider = getLoginMethodsUseCaseProvider;
    this.errorMapperProvider = errorMapperProvider;
  }

  @Override
  public StartViewModel get() {
    return newInstance(getLoginMethodsUseCaseProvider.get(), errorMapperProvider.get());
  }

  public static StartViewModel_Factory create(
      Provider<GetLoginMethodsUseCase> getLoginMethodsUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider) {
    return new StartViewModel_Factory(getLoginMethodsUseCaseProvider, errorMapperProvider);
  }

  public static StartViewModel newInstance(GetLoginMethodsUseCase getLoginMethodsUseCase,
      ErrorMapper errorMapper) {
    return new StartViewModel(getLoginMethodsUseCase, errorMapper);
  }
}
