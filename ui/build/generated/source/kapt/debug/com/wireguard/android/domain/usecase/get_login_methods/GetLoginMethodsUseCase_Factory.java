package com.wireguard.android.domain.usecase.get_login_methods;

import com.wireguard.android.domain.repository.AuthRepository;
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
public final class GetLoginMethodsUseCase_Factory implements Factory<GetLoginMethodsUseCase> {
  private final Provider<AuthRepository> authRepositoryProvider;

  public GetLoginMethodsUseCase_Factory(Provider<AuthRepository> authRepositoryProvider) {
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public GetLoginMethodsUseCase get() {
    return newInstance(authRepositoryProvider.get());
  }

  public static GetLoginMethodsUseCase_Factory create(
      Provider<AuthRepository> authRepositoryProvider) {
    return new GetLoginMethodsUseCase_Factory(authRepositoryProvider);
  }

  public static GetLoginMethodsUseCase newInstance(AuthRepository authRepository) {
    return new GetLoginMethodsUseCase(authRepository);
  }
}
