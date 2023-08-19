package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.model.ApiUser
import retrofit2.http.GET

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/18 14:26
 * @description
 */
interface ApiService {

    @GET("user")
    suspend fun getUsers(): List<ApiUser>

    @GET("more-user")
    suspend fun getMoreUsers(): List<ApiUser>

    @GET("error")
    suspend fun getUsersWithError(): List<ApiUser>
}