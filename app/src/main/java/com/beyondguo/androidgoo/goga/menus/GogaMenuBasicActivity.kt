package com.beyondguo.androidgoo.goga.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.beyondguo.androidgoo.R
import kotlinx.coroutines.launch

class GogaMenuBasicActivity : AppCompatActivity(), GogaMenuInterface {

    private val vm by lazy { ViewModelProvider(this)[GogaMenuBasicViewModel::class.java] }
    private var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goga_menu_basic)
        button = findViewById<Button>(R.id.button1)
        button?.setOnClickListener {
            Log.i("Goga", button?.left.toString())
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            Log.i("Goga", button?.left.toString())
            lifecycleScope.launch {
                vm.fetchAndShowUser()
            }
        }
    }
}