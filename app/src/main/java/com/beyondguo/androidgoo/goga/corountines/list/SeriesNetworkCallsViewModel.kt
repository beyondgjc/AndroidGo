package com.beyondguo.androidgoo.goga.corountines.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beyondguo.androidgoo.data.api.ApiHelper
import com.beyondguo.androidgoo.data.local.DatabaseHelper
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import kotlinx.coroutines.launch

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 15:51
 * @description
 */
class SeriesNetworkCallsViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
): ViewModel() {
    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val usersFromApi = apiHelper.getUsers()
                val moreUsersFromApi = apiHelper.getMoreUsers()
                val allUserFromApi = mutableListOf<ApiUser>()
                allUserFromApi.addAll(usersFromApi)
                allUserFromApi.addAll(moreUsersFromApi)
                uiState.postValue(UiState.Success(allUserFromApi))
            }catch (e: Exception){
                uiState.postValue(UiState.Error("获取用户失败"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> = uiState
}