package com.wireguard.android.presentation.common;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/wireguard/android/presentation/common/ErrorMapper;", "", "()V", "mapDataError", "Lcom/wireguard/android/presentation/common/UiText;", "error", "Lcom/wireguard/android/common/error/DataError;", "mapToUiText", "Lcom/wireguard/android/common/error/Error;", "mapValidationError", "Lcom/wireguard/android/common/error/ValidationError;", "mapValidationErrorToField", "Lkotlin/Pair;", "Lcom/wireguard/android/common/error/ValidationFieldType;", "ui_debug"})
public final class ErrorMapper {
    
    @javax.inject.Inject
    public ErrorMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.wireguard.android.presentation.common.UiText mapToUiText(@org.jetbrains.annotations.NotNull
    com.wireguard.android.common.error.Error error) {
        return null;
    }
    
    private final com.wireguard.android.presentation.common.UiText mapDataError(com.wireguard.android.common.error.DataError error) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<com.wireguard.android.common.error.ValidationFieldType, com.wireguard.android.presentation.common.UiText> mapValidationErrorToField(@org.jetbrains.annotations.NotNull
    com.wireguard.android.common.error.ValidationError error) {
        return null;
    }
    
    private final com.wireguard.android.presentation.common.UiText mapValidationError(com.wireguard.android.common.error.ValidationError error) {
        return null;
    }
}