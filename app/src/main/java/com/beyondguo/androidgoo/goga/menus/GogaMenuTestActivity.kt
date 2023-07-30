package com.beyondguo.androidgoo.goga.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beyondguo.androidgoo.R

class GogaMenuTestActivity : AppCompatActivity(), GogaMenuInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goga_menu_test)
    }
}