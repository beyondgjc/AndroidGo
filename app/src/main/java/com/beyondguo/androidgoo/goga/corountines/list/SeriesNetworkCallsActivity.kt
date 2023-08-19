package com.beyondguo.androidgoo.goga.corountines.list

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondguo.androidgoo.data.api.ApiHelperImpl
import com.beyondguo.androidgoo.data.api.RetrofitBuilder
import com.beyondguo.androidgoo.data.local.DatabaseBuilder
import com.beyondguo.androidgoo.data.local.DatabaseHelperImpl
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.databinding.ActivitySeriesNetworkCallsBinding
import com.beyondguo.androidgoo.goga.corountines.CorountineItem
import com.beyondguo.androidgoo.goga.corountines.base.ApiUserAdapter
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import com.beyondguo.androidgoo.goga.corountines.base.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class SeriesNetworkCallsActivity : AppCompatActivity(), CorountineItem {

    private var _binding: ActivitySeriesNetworkCallsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SeriesNetworkCallsViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySeriesNetworkCallsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ApiUserAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.recyclerView.context,
            (binding.recyclerView.layoutManager as LinearLayoutManager).orientation))
        binding.recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(
            ApiHelperImpl(RetrofitBuilder.apiService),
            DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        ))[SeriesNetworkCallsViewModel::class.java]
    }

    private fun setupObserver() {
        viewModel.getUiState().observe(this){
            when(it){
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is UiState.Error -> {
                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()
                }
                is UiState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun renderList(users: List<ApiUser>){
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}