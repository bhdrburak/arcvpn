package com.wireguard.android.presentation.hostsetup;

import com.wireguard.android.common.error.UserDataValidator;
import com.wireguard.android.presentation.common.ErrorMapper;
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
public final class HostSetupFragment_MembersInjector implements MembersInjector<HostSetupFragment> {
  private final Provider<ErrorMapper> errorMapperProvider;

  private final Provider<UserDataValidator> userDataValidatorProvider;

  public HostSetupFragment_MembersInjector(Provider<ErrorMapper> errorMapperProvider,
      Provider<UserDataValidator> userDataValidatorProvider) {
    this.errorMapperProvider = errorMapperProvider;
    this.userDataValidatorProvider = userDataValidatorProvider;
  }

  public static MembersInjector<HostSetupFragment> create(Provider<ErrorMapper> errorMapperProvider,
      Provider<UserDataValidator> userDataValidatorProvider) {
    return new HostSetupFragment_MembersInjector(errorMapperProvider, userDataValidatorProvider);
  }

  @Override
  public void injectMembers(HostSetupFragment instance) {
    injectErrorMapper(instance, errorMapperProvider.get());
    injectUserDataValidator(instance, userDataValidatorProvider.get());
  }

  @InjectedFieldSignature("com.wireguard.android.presentation.hostsetup.HostSetupFragment.errorMapper")
  public static void injectErrorMapper(HostSetupFragment instance, ErrorMapper errorMapper) {
    instance.errorMapper = errorMapper;
  }

  @InjectedFieldSignature("com.wireguard.android.presentation.hostsetup.HostSetupFragment.userDataValidator")
  public static void injectUserDataValidator(HostSetupFragment instance,
      UserDataValidator userDataValidator) {
    instance.userDataValidator = userDataValidator;
  }
}
