package com.wireguard.android.data.common;

import com.wireguard.android.common.network.NetworkChecker;
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
public final class ErrorHandler_Factory implements Factory<ErrorHandler> {
  private final Provider<NetworkChecker> networkCheckerProvider;

  public ErrorHandler_Factory(Provider<NetworkChecker> networkCheckerProvider) {
    this.networkCheckerProvider = networkCheckerProvider;
  }

  @Override
  public ErrorHandler get() {
    return newInstance(networkCheckerProvider.get());
  }

  public static ErrorHandler_Factory create(Provider<NetworkChecker> networkCheckerProvider) {
    return new ErrorHandler_Factory(networkCheckerProvider);
  }

  public static ErrorHandler newInstance(NetworkChecker networkChecker) {
    return new ErrorHandler(networkChecker);
  }
}
