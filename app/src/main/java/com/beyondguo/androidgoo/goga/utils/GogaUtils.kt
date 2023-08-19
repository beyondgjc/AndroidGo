package com.beyondguo.androidgoo.goga.utils

import com.beyondguo.androidgoo.goga.menus.GogaMenuBasicActivity
import com.beyondguo.androidgoo.goga.menus.GogaMenuCorountinesActivity
import com.beyondguo.androidgoo.goga.menus.GogaMenuTestActivity
import com.beyondguo.androidgoo.goga.model.GogaMenuModel

object GogaUtils {

    fun getMenuList(): List<GogaMenuModel>{
        return listOf(GogaMenuModel("测试按钮", GogaMenuTestActivity::class.java),
                      GogaMenuModel("Basic", GogaMenuBasicActivity::class.java),
                      GogaMenuModel("Corountines", GogaMenuCorountinesActivity::class.java)
        )
    }

}