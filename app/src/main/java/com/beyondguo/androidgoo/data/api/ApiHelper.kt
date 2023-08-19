package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.model.ApiUser

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:51
 * @description
 */
interface ApiHelper {

    suspend fun getUsers(): List<ApiUser>

    suspend fun getMoreUsers(): List<ApiUser>

    suspend fun getUsersWithError(): List<ApiUser>
}