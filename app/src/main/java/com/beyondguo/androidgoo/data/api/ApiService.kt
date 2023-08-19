package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.local.entity.User
import com.beyondguo.androidgoo.data.model.ApiUser
import retrofit2.http.GET

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/18 14:26
 * @description
 */
interface ApiService {

    @GET("user")
    suspend fun getUsers(): List<User>

    @GET("more-user")
    suspend fun getMoreUsers(): List<User>

    @GET("error")
    suspend fun getUsersWithError(): List<ApiUser>
}