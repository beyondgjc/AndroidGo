package com.beyondguo.androidgoo.goga.menus

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.goga.corountines.CorountinesAdapter
import com.beyondguo.androidgoo.goga.corountines.CoroutinesMenuList

/**
 * @author guojichao@bytedance.com
 * @date 2023/8/19 12:44
 * @description
 */
class GogaMenuCorountinesActivity : AppCompatActivity(), GogaMenuInterface {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goga_menu_corountine)
        val recycle = findViewById<RecyclerView>(R.id.recycleView)
        recycle.layoutManager = LinearLayoutManager(this)
        recycle.adapter = CorountinesAdapter(this, CoroutinesMenuList.getMenu())
    }
}