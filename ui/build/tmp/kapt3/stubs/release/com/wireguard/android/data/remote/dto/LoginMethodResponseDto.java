package com.wireguard.android.data.remote.dto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/wireguard/android/data/remote/dto/LoginMethodResponseDto;", "", "credential", "", "certification", "validDevice", "(ZZZ)V", "getCertification", "()Z", "getCredential", "getValidDevice", "ui_release"})
public final class LoginMethodResponseDto {
    private final boolean credential = false;
    private final boolean certification = false;
    private final boolean validDevice = false;
    
    public LoginMethodResponseDto(boolean credential, boolean certification, boolean validDevice) {
        super();
    }
    
    public final boolean getCredential() {
        return false;
    }
    
    public final boolean getCertification() {
        return false;
    }
    
    public final boolean getValidDevice() {
        return false;
    }
}