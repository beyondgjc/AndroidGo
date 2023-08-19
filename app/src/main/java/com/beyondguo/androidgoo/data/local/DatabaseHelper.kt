package com.beyondguo.androidgoo.data.local

import com.beyondguo.androidgoo.data.local.entity.User

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:42
 * @description
 */
interface DatabaseHelper {
    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)
}