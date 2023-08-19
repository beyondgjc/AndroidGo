package com.beyondguo.androidgoo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beyondguo.androidgoo.data.local.dao.UserDao
import com.beyondguo.androidgoo.data.local.entity.User

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:34
 * @description
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}