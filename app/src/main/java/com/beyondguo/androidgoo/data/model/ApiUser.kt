package com.beyondguo.androidgoo.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:19
 * @description
 */
data class ApiUser (
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("avatar")
    val avatar: String = ""
)