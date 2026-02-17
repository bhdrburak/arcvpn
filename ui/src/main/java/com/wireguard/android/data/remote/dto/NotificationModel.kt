package com.wireguard.android.data.remote.dto

import com.google.gson.annotations.SerializedName


data class NotificationModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("user_id")
    val userId: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("read_at")
    val readAt: String?,
    @SerializedName("is_read")
    val isRead: Boolean?,
)