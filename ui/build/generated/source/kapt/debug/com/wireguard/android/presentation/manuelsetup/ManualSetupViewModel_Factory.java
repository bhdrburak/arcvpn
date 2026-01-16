package com.wireguard.android.presentation.manuelsetup;

import com.wireguard.android.common.error.UserDataValidator;
import com.wireguard.android.domain.usecase.login.LoginUseCase;
import com.wireguard.android.domain.util.DeviceInfoProvider;
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
public final class ManualSetupViewModel_Factory implements Factory<ManualSetupViewModel> {
  private final Provider<LoginUseCase> loginUseCaseProvider;

  private final Provider<ErrorMapper> errorMapperProvider;

  private final Provider<UserDataValidator> userDataValidatorProvider;

  private final Provider<DeviceInfoProvider> deviceInfoProvider;

  public ManualSetupViewModel_Factory(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider,
      Provider<UserDataValidator> userDataValidatorProvider,
      Provider<DeviceInfoProvider> deviceInfoProvider) {
    this.loginUseCaseProvider = loginUseCaseProvider;
    this.errorMapperProvider = errorMapperProvider;
    this.userDataValidatorProvider = userDataValidatorProvider;
    this.deviceInfoProvider = deviceInfoProvider;
  }

  @Override
  public ManualSetupViewModel get() {
    return newInstance(loginUseCaseProvider.get(), errorMapperProvider.get(), userDataValidatorProvider.get(), deviceInfoProvider.get());
  }

  public static ManualSetupViewModel_Factory create(Provider<LoginUseCase> loginUseCaseProvider,
      Provider<ErrorMapper> errorMapperProvider,
      Provider<UserDataValidator> userDataValidatorProvider,
      Provider<DeviceInfoProvider> deviceInfoProvider) {
    return new ManualSetupViewModel_Factory(loginUseCaseProvider, errorMapperProvider, userDataValidatorProvider, deviceInfoProvider);
  }

  public static ManualSetupViewModel newInstance(LoginUseCase loginUseCase, ErrorMapper errorMapper,
      UserDataValidator userDataValidator, DeviceInfoProvider deviceInfoProvider) {
    return new ManualSetupViewModel(loginUseCase, errorMapper, userDataValidator, deviceInfoProvider);
  }
}
