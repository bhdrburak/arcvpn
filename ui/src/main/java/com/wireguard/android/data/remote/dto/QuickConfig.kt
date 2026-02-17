package com.wireguard.android.data.remote.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuickConfig(
    @SerializedName("config")
    val config: String,
    @SerializedName("details")
    val details: Details,
    @SerializedName("success")
    val success: Boolean
) : Parcelable

@Parcelize
data class Details(
    @SerializedName("client_ip")
    val clientIp: String,
    @SerializedName("dns")
    val dns: String,
    @SerializedName("node_location")
    val nodeLocation: String,
    @SerializedName("node_name")
    val nodeName: String,
    @SerializedName("server_endpoint")
    val serverEndpoint: String
) : Parcelable