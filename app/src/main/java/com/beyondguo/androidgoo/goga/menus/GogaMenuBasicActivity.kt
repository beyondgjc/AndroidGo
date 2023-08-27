package com.beyondguo.androidgoo.goga.menus

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.beyondguo.androidgoo.R
import kotlinx.coroutines.launch


class GogaMenuBasicActivity : AppCompatActivity(), GogaMenuInterface {

    private val vm by lazy { ViewModelProvider(this)[GogaMenuBasicViewModel::class.java] }
    private var button: Button? = null

    fun getPackageManager(context: Context): PackageManager? {
        return context.packageManager
    }



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