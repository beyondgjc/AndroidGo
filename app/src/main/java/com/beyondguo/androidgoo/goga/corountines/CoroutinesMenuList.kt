package com.beyondguo.androidgoo.goga.corountines

import com.beyondguo.androidgoo.goga.corountines.list.SingleNetworkCallActivity

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 13:14
 * @description
 */
object CoroutinesMenuList {
    fun getMenu() : List<CorountinesModel>{
        return listOf(CorountinesModel(SingleNetworkCallActivity::class.java.simpleName, SingleNetworkCallActivity::class.java))
    }
}