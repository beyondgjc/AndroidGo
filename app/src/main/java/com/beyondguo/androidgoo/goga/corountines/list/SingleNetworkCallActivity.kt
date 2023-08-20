package com.beyondguo.androidgoo.goga.corountines.list

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beyondguo.androidgoo.R
import com.beyondguo.androidgoo.data.api.ApiHelperImpl
import com.beyondguo.androidgoo.data.api.RetrofitBuilder
import com.beyondguo.androidgoo.data.local.DatabaseBuilder
import com.beyondguo.androidgoo.data.local.DatabaseHelperImpl
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.databinding.ActivitySingleNetworkCallBinding
import com.beyondguo.androidgoo.goga.corountines.CorountineItem
import com.beyondguo.androidgoo.goga.corountines.base.ApiUserAdapter
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import com.beyondguo.androidgoo.goga.corountines.base.ViewModelFactory

class SingleNetworkCallActivity : AppCompatActivity(), CorountineItem {

    private var _binding: ActivitySingleNetworkCallBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SingleNetworkCallViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySingleNetworkCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.getUiState().observe(this){
            when(it){
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recycleView.visibility = View.VISIBLE
                }
                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recycleView.visibility = View.GONE
                }
                is UiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(
            ApiHelperImpl(RetrofitBuilder.apiService),
            DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        )
        )[SingleNetworkCallViewModel::class.java]
    }

    private fun setupUI() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ApiUserAdapter(arrayListOf())
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context,
            (recyclerView.layoutManager as LinearLayoutManager).orientation))
        recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(users: List<ApiUser>){
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}