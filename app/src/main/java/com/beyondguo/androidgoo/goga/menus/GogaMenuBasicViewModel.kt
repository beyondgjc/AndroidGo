package com.beyondguo.androidgoo.goga.menus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/17 15:17
 * @description
 */
class GogaMenuBasicViewModel: ViewModel() {

    suspend fun fetchAndShowUser(){
        GlobalScope.launch(Dispatchers.Main) {
            val user = fetchUser()
            showUser()
        }

        val deferred = viewModelScope.async(Dispatchers.IO) {
            return@async 10
        }
        val result = deferred.await()

    }

    suspend fun fetchUser(): Int{
        return withContext(Dispatchers.IO){
            delay(5000)
            1
        }
    }

    fun showUser(){
        println("OK")
    }

}