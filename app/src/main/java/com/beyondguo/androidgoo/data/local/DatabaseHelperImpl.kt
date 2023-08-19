package com.beyondguo.androidgoo.data.local

import com.beyondguo.androidgoo.data.local.entity.User

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:43
 * @description
 */
class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {
    override suspend fun getUsers(): List<User> {
        return appDatabase.userDao().getAll()
    }

    override suspend fun insertAll(users: List<User>) {
        appDatabase.userDao().insertAll(users)
    }
}