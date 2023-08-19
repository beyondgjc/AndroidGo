package com.beyondguo.androidgoo.goga.corountines.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.goga.corountines.CorountineItem

class SingleNetworkCallActivity : AppCompatActivity(), CorountineItem {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_network_call)
    }
}