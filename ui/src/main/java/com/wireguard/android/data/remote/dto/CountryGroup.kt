package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CountryGroup(
    @SerializedName("country")
    val country: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("flag_emoji")
    val flagEmoji: String,
    @SerializedName("locations")
    val locations: Map<String, List<NodeModel>>
)