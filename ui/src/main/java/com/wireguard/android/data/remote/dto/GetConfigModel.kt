package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class GetConfigModel(

    @SerializedName("node_id")
    val nodeId: Int?,
)
