package com.wireguard.android.di;

import com.wireguard.android.common.error.UserDataValidator;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AppModule_ProvideUserDataValidatorFactory implements Factory<UserDataValidator> {
  @Override
  public UserDataValidator get() {
    return provideUserDataValidator();
  }

  public static AppModule_ProvideUserDataValidatorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static UserDataValidator provideUserDataValidator() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserDataValidator());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideUserDataValidatorFactory INSTANCE = new AppModule_ProvideUserDataValidatorFactory();
  }
}
