package com.beyondguo.androidgoo.data.api

import com.beyondguo.androidgoo.data.model.ApiUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:53
 * @description
 */
class ApiHelperImpl(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers(): List<ApiUser> =
        withContext(Dispatchers.IO) {
            apiService.getUsers()
        }

    override suspend fun getMoreUsers(): List<ApiUser> =
        withContext(Dispatchers.IO){
            apiService.getMoreUsers()
        }

    override suspend fun getUsersWithError(): List<ApiUser> =
        withContext(Dispatchers.IO) {
            apiService.getUsersWithError()
        }
}