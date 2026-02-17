package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("company_id")
    val companyId: Int?,
    @SerializedName("is_system_admin")
    val isSystemAdmin: Boolean?,
    @SerializedName("is_company_admin")
    val isCompanyAdmin: Boolean?,
    @SerializedName("is_active")
    val isActive: Boolean?,
    @SerializedName("email_verified")
    val emailVerified: Boolean?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
)
