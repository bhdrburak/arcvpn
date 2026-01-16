/*
 * Copyright © 2017-2025 WireGuard LLC. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.wireguard.android.common.knobs
import android.content.RestrictionsManager
import android.util.Log
import androidx.core.content.getSystemService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wireguard.android.Application
import com.wireguard.android.domain.model.ProfileDetails
import com.wireguard.android.domain.model.RawVpnProfile
import com.wireguard.android.domain.model.VpnProfile

object ProfileManager {

    private const val KEY_PROFILES_JSON = "vpn_profiles_json"
    private const val KEY_ACTIVE_PROFILE_ID = "active_profile_name"
    private const val KEY_CACHE_PROFILES_JSON = "cached_profiles_json"
    private const val AGENT_PROFILE_START_ID = 1
    private const val USER_PROFILE_START_ID = 1000


    private val restrictions: RestrictionsManager = Application.get().getSystemService()!!

    private var vpnProfileList: List<VpnProfile> = emptyList()
    private var cachedProfiles: MutableList<VpnProfile> = mutableListOf()


    init {
        loadProfiles()
    }

    fun updateFromRestrictions() {
        val restrictionsBundle = restrictions.applicationRestrictions
        val profilesJson = restrictionsBundle.getString("vpnProfiles")

        if (!profilesJson.isNullOrEmpty()) {
            Application.getCacheManager().writeString(KEY_PROFILES_JSON, profilesJson)
            parseAndMap(profilesJson)
        } else {
            clearProfiles()
        }
        validateActiveProfile()
    }

    private fun loadProfiles() {
        val profilesJson = Application.getCacheManager().readString(KEY_PROFILES_JSON, "")
        if (profilesJson.isNotEmpty()) {
            parseAndMap(profilesJson)
        }

        // Cache profilleri yükle
        val cachedJson = Application.getCacheManager().readString(KEY_CACHE_PROFILES_JSON, "")
        if (cachedJson.isNotEmpty()) {
            parseAndCacheUserProfiles(cachedJson)
        }
    }
    private fun parseAndCacheUserProfiles(json: String) {
        cachedProfiles = try {
            val list: List<VpnProfile> = Gson().fromJson(json, object : TypeToken<List<VpnProfile>>() {}.type)
            list.mapIndexed { index, profile ->
                profile.copy(
                    id = USER_PROFILE_START_ID + index,
                    isUserProfile = true
                )
            }.toMutableList()
        } catch (e: Exception) {
            Log.e("ProfileManager", "Failed to parse cached profiles JSON", e)
            mutableListOf()
        }
    }

    private fun parseAndMap(json: String) {
        vpnProfileList = try {
            val rawList: List<RawVpnProfile> = Gson().fromJson(json, object : TypeToken<List<RawVpnProfile>>() {}.type)
            rawList.mapIndexed { index, raw ->
                VpnProfile(
                    id = AGENT_PROFILE_START_ID + index ,
                    profileName = raw.profileName,
                    details = raw.details.copy(
                        host = raw.details.host?.replaceFirst("https://", "", ignoreCase = true)
                            ?.replaceFirst("http://", "", ignoreCase = true)
                            ?.trimEnd('/')
                    ),
                    isUserProfile = false
                )
            }
        } catch (e: Exception) {
            Log.e("ProfileManager", "Failed to parse profiles JSON", e)
            emptyList()
        }
    }


    fun addUserProfileToCache(host: String, port: String, connectionName: String) {
        val duplicateExists = getAllProfiles().any {
            it.details.host.equals(host, ignoreCase = true) &&
                    it.details.port?.toString() == port &&
                    it.details.connectionName.equals(connectionName, ignoreCase = true)
        }

        if (duplicateExists) {
            throw IllegalArgumentException("A profile with the same host, port, and connection name already exists.")
        }

        val nextId = getAllProfiles().maxOfOrNull { it.id }?.plus(1) ?: 1
        val newProfile = VpnProfile(
            id = nextId,
            profileName = connectionName,
            details = ProfileDetails(
                connectionName = connectionName,
                host = host,
                port = port.toIntOrNull(),
                alwaysOnVpn = false,
                connectionCheckTime = 60,
                autoStartOnDevice = false,
                allowedApplications = emptyList()
            ),
            isUserProfile = true
        )
        cachedProfiles.add(newProfile)
        persistCachedProfiles()
    }
    private fun persistCachedProfiles() {
        val json = Gson().toJson(cachedProfiles)
        Application.getCacheManager().writeString(KEY_CACHE_PROFILES_JSON, json)
    }

    fun getAllProfiles(): List<VpnProfile> {
        return vpnProfileList + cachedProfiles
    }

    fun setActiveProfile(id: Int) {
        Application.getCacheManager().writeString(KEY_ACTIVE_PROFILE_ID, id.toString())
    }
    fun setActiveProfile(id: Int, isUserProfile: Boolean) {
        Application.getCacheManager().writeString(KEY_ACTIVE_PROFILE_ID, id.toString())
        Application.getCacheManager().writeBoolean("active_profile_is_user", isUserProfile)
    }

    fun getActiveProfile(): VpnProfile? {
        val id = Application.getCacheManager().readString(KEY_ACTIVE_PROFILE_ID, "").toIntOrNull()
        val isUser = Application.getCacheManager().readBoolean("active_profile_is_user", false)

        return if (isUser) {
            cachedProfiles.find { it.id == id }
        } else {
            vpnProfileList.find { it.id == id }
        }
    }

    private fun validateActiveProfile() {
        val id = Application.getCacheManager().readString(KEY_ACTIVE_PROFILE_ID, "").toIntOrNull()
        val exists = getAllProfiles().any { it.id == id }

        if (!exists) {
            clearActiveSelectedProfile()
        }
    }
    private fun clearProfiles() {
        vpnProfileList = emptyList()
        Application.getCacheManager().writeString(KEY_PROFILES_JSON,"")
    }

    fun clearActiveSelectedProfile(){
        Application.getCacheManager().writeString(KEY_ACTIVE_PROFILE_ID,"")
    }

    fun deleteUserProfile(id: Int) {
        val removed = cachedProfiles.removeIf { it.id == id }
        if (removed) {
            persistCachedProfiles()
            if (getActiveProfile()?.id == id) {
                clearActiveSelectedProfile()
            }
        }
    }
    fun restoreUserProfile(profile: VpnProfile) { //undo işlemi için ekledik
        cachedProfiles.add(profile)
        persistCachedProfiles()
    }

}