package com.beyondguo.androidgoo.goga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondguo.androidgoo.databinding.ActivityGogaMainBinding
import com.beyondguo.androidgoo.goga.utils.GogaUtils

class GogaMainActivity : AppCompatActivity() {

    private var _binding: ActivityGogaMainBinding? = null

    private val gogaMainViewHolder by lazy { ViewModelProvider(this)[GogaMainViewModel::class.java] }

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGogaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = GogaMainRecycleViewAdapter(this, GogaUtils.getMenuList())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}