package com.beyondguo.androidgoo.goga.corountines.base

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 14:33
 * @description
 */
sealed interface UiState<out T> {
    data class Success<T>(val data: T): UiState<T>

    data class Error(val message: String): UiState<Nothing>

    object Loading: UiState<Nothing>
}