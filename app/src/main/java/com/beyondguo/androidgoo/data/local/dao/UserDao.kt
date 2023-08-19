package com.beyondguo.androidgoo.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.beyondguo.androidgoo.data.local.entity.User

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:31
 * @description
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun delete(user: User)
}