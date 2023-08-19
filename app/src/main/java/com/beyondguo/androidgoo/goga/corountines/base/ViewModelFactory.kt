package com.beyondguo.androidgoo.goga.corountines.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.beyondguo.androidgoo.data.api.ApiHelper
import com.beyondguo.androidgoo.data.local.DatabaseHelper
import com.beyondguo.androidgoo.goga.corountines.list.SingleNetworkCallViewModel
import java.lang.IllegalArgumentException

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 14:27
 * @description
 */
class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper):
    ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)){
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class, it's not a view model")
    }
}