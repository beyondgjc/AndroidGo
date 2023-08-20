package com.beyondguo.androidgoo.goga.corountines

import com.beyondguo.androidgoo.goga.corountines.list.ParallelNetworkCallsActivity
import com.beyondguo.androidgoo.goga.corountines.list.RoomDBActivity
import com.beyondguo.androidgoo.goga.corountines.list.SeriesNetworkCallsActivity
import com.beyondguo.androidgoo.goga.corountines.list.SingleNetworkCallActivity

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 13:14
 * @description
 */
object CoroutinesMenuList {
    fun getMenu() : List<CorountinesModel>{
        return listOf(CorountinesModel(SingleNetworkCallActivity::class.java.simpleName, SingleNetworkCallActivity::class.java)
                    , CorountinesModel(SeriesNetworkCallsActivity::class.java.simpleName, SeriesNetworkCallsActivity::class.java)
                    , CorountinesModel(ParallelNetworkCallsActivity::class.java.simpleName, ParallelNetworkCallsActivity::class.java)
                    , CorountinesModel(RoomDBActivity::class.java.simpleName, RoomDBActivity::class.java)
                )
    }
}