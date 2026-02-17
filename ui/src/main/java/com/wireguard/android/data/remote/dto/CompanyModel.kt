package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CompanyModel(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
)
