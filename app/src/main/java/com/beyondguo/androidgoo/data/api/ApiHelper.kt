package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.local.entity.User
import com.beyondguo.androidgoo.data.model.ApiUser

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:51
 * @description
 */
interface ApiHelper {

    suspend fun getUsers(): List<User>

    suspend fun getMoreUsers(): List<User>

    suspend fun getUsersWithError(): List<ApiUser>
}