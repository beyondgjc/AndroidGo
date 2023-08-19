package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.local.entity.User
import com.beyondguo.androidgoo.data.model.ApiUser

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:53
 * @description
 */
class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers(): List<User> = apiService.getUsers()

    override suspend fun getMoreUsers(): List<User> = apiService.getMoreUsers()

    override suspend fun getUsersWithError(): List<ApiUser> = apiService.getUsersWithError()
}