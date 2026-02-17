package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("token")
    val token: String?,
    @SerializedName("is_system_admin")
    val isSystemAdmin: Boolean?,
    @SerializedName("is_company_admin")
    val isCompanyAdmin: Boolean?,
    @SerializedName("user")
    val user: UserModel?,
    @SerializedName("company")
    val company: CompanyModel?,
)
