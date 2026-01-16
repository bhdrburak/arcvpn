package com.wireguard.android.presentation.common;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ErrorMapper_Factory implements Factory<ErrorMapper> {
  @Override
  public ErrorMapper get() {
    return newInstance();
  }

  public static ErrorMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ErrorMapper newInstance() {
    return new ErrorMapper();
  }

  private static final class InstanceHolder {
    private static final ErrorMapper_Factory INSTANCE = new ErrorMapper_Factory();
  }
}
