package com.beyondguo.androidgoo.data.local

import android.content.Context
import androidx.room.Room

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 20:36
 * @description
 */
object DatabaseBuilder {
    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase{
        if(INSTANCE == null){
            synchronized(AppDatabase::class){
                if(INSTANCE == null){
                    INSTANCE = buildRoomDB(context)
                }
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "goga-kotlin-coroutines"
        ).build()
}