package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AllNodeModel(

    @SerializedName("nodes")
    val nodes: List<NodeModel>?,
    @SerializedName("grouped")
    val grouped: Map<String, CountryGroup>,
    @SerializedName("plan_type")
    val planType: String?,
    @SerializedName("total_nodes")
    val totalNodes: Int?,
    @SerializedName("user_license")
    val userLicense: String?,
)
