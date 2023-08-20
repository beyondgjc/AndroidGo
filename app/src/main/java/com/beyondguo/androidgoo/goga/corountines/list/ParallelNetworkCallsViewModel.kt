package com.beyondguo.androidgoo.goga.corountines.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beyondguo.androidgoo.data.api.ApiHelper
import com.beyondguo.androidgoo.data.local.DatabaseHelper
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 16:21
 * @description
 */
class ParallelNetworkCallsViewModel(
    private val apiHelper: ApiHelper,
    private val dbhelper: DatabaseHelper
): ViewModel() {

    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                coroutineScope {
                    val usersFromApiDeferred = async { apiHelper.getUsers() }
                    val moreUsersFromApiDeferred = async { apiHelper.getMoreUsers() }

                    val usersFromApi = usersFromApiDeferred.await()
                    val moreUsersFromApi = moreUsersFromApiDeferred.await()

                    val allUsersFromApi = mutableListOf<ApiUser>()
                    allUsersFromApi.addAll(usersFromApi)
                    allUsersFromApi.addAll(moreUsersFromApi)

                    uiState.postValue(UiState.Success(allUsersFromApi))
                }
            }catch (e: Exception){
                uiState.postValue(UiState.Error("并行请求失败"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> = uiState

    private fun fetchUsersIgnoreError() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            // supervisorScope 一个job error不会crash
            supervisorScope {
                val usersFromApiDeferred = async { apiHelper.getUsers() }
                val moreUsersFromApiDeferred = async { apiHelper.getMoreUsers() }

                val usersFromApi = try {
                    usersFromApiDeferred.await()
                }catch (e: Exception){
                    emptyList()
                }
                val moreUsersFromApi = try {
                    moreUsersFromApiDeferred.await()
                }catch (e: Exception){
                    emptyList()
                }

                val allUsersFromApi = mutableListOf<ApiUser>()
                allUsersFromApi.addAll(usersFromApi)
                allUsersFromApi.addAll(moreUsersFromApi)

                uiState.postValue(UiState.Success(allUsersFromApi))
            }
        }
    }
}