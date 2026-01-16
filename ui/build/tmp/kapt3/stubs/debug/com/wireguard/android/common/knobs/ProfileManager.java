package com.wireguard.android.common.knobs;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u0004\u0018\u00010\fJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0012H\u0002J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\fJ\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010#\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u0012J\b\u0010\'\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/wireguard/android/common/knobs/ProfileManager;", "", "()V", "AGENT_PROFILE_START_ID", "", "KEY_ACTIVE_PROFILE_ID", "", "KEY_CACHE_PROFILES_JSON", "KEY_PROFILES_JSON", "USER_PROFILE_START_ID", "cachedProfiles", "", "Lcom/wireguard/android/domain/model/VpnProfile;", "restrictions", "Landroid/content/RestrictionsManager;", "vpnProfileList", "", "addUserProfileToCache", "", "host", "port", "connectionName", "clearActiveSelectedProfile", "clearProfiles", "deleteUserProfile", "id", "getActiveProfile", "getAllProfiles", "loadProfiles", "parseAndCacheUserProfiles", "json", "parseAndMap", "persistCachedProfiles", "restoreUserProfile", "profile", "setActiveProfile", "isUserProfile", "", "updateFromRestrictions", "validateActiveProfile", "ui_debug"})
public final class ProfileManager {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_PROFILES_JSON = "vpn_profiles_json";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_ACTIVE_PROFILE_ID = "active_profile_name";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_CACHE_PROFILES_JSON = "cached_profiles_json";
    private static final int AGENT_PROFILE_START_ID = 1;
    private static final int USER_PROFILE_START_ID = 1000;
    @org.jetbrains.annotations.NotNull
    private static final android.content.RestrictionsManager restrictions = null;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<com.wireguard.android.domain.model.VpnProfile> vpnProfileList;
    @org.jetbrains.annotations.NotNull
    private static java.util.List<com.wireguard.android.domain.model.VpnProfile> cachedProfiles;
    @org.jetbrains.annotations.NotNull
    public static final com.wireguard.android.common.knobs.ProfileManager INSTANCE = null;
    
    private ProfileManager() {
        super();
    }
    
    public final void updateFromRestrictions() {
    }
    
    private final void loadProfiles() {
    }
    
    private final void parseAndCacheUserProfiles(java.lang.String json) {
    }
    
    private final void parseAndMap(java.lang.String json) {
    }
    
    public final void addUserProfileToCache(@org.jetbrains.annotations.NotNull
    java.lang.String host, @org.jetbrains.annotations.NotNull
    java.lang.String port, @org.jetbrains.annotations.NotNull
    java.lang.String connectionName) {
    }
    
    private final void persistCachedProfiles() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.wireguard.android.domain.model.VpnProfile> getAllProfiles() {
        return null;
    }
    
    public final void setActiveProfile(int id) {
    }
    
    public final void setActiveProfile(int id, boolean isUserProfile) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.wireguard.android.domain.model.VpnProfile getActiveProfile() {
        return null;
    }
    
    private final void validateActiveProfile() {
    }
    
    private final void clearProfiles() {
    }
    
    public final void clearActiveSelectedProfile() {
    }
    
    public final void deleteUserProfile(int id) {
    }
    
    public final void restoreUserProfile(@org.jetbrains.annotations.NotNull
    com.wireguard.android.domain.model.VpnProfile profile) {
    }
}