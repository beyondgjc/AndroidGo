package com.beyondguo.androidgoo.goga.corountines.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beyondguo.androidgoo.data.api.ApiHelper
import com.beyondguo.androidgoo.data.local.DatabaseHelper
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 13:37
 * @description
 */
class SingleNetworkCallViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
): ViewModel() {

    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()
    private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
        uiState.postValue(UiState.Error("error handler"))
    }

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                withTimeout(100) {
                    val usersFromApi = apiHelper.getUsers()
                    uiState.postValue(UiState.Success(usersFromApi))
                }
            }catch (e: TimeoutCancellationException) {
                uiState.postValue(UiState.Error("Time out"))
            } catch (e: Exception){
                uiState.postValue(UiState.Error(e.toString()))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> {
        return uiState
    }

    private fun fetchUsersWithExceptionHandler() {
        viewModelScope.launch(exceptionHandler) {
            uiState.postValue(UiState.Loading)
            withTimeout(100) {
                val usersFromApi = apiHelper.getUsers()
                uiState.postValue(UiState.Success(usersFromApi))
            }
        }
    }

}