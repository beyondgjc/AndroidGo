package com.beyondguo.androidgoo.goga.corountines.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beyondguo.androidgoo.data.api.ApiHelper
import com.beyondguo.androidgoo.data.local.DatabaseHelper
import com.beyondguo.androidgoo.data.local.entity.User
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import kotlinx.coroutines.launch

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 18:11
 * @description
 */
class RoomDBViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
): ViewModel() {
    private val uiState = MutableLiveData<UiState<List<User>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val usersFromDb = dbHelper.getUsers()
                if(usersFromDb.isEmpty()){
                    val usersFromApi = apiHelper.getUsers()
                    val userToInsertInDb =
                        usersFromApi.map { User(it.id, it.name, it.email, it.avatar) }
                    dbHelper.insertAll(userToInsertInDb)
                    uiState.postValue(UiState.Success(userToInsertInDb))
                } else {
                    uiState.postValue(UiState.Success(usersFromDb))
                }
            }catch (e: Exception){
                uiState.postValue(UiState.Error("Room为空，远程获取用户失败"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<User>>> = uiState
}