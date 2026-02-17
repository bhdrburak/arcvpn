package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NodeModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("country_code")
    val countryCode: String?,
    @SerializedName("ip_address")
    val ipAddress: String?,
    @SerializedName("port")
    val port: Int?,
    @SerializedName("protocol")
    val protocol: String?,
    @SerializedName("load_percent")
    val loadPercent: Int?,
    @SerializedName("capacity")
    val capacity: Int?,
    @SerializedName("current_users")
    val currentUsers: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("has_access")
    val hasAccess: Boolean?,
)
