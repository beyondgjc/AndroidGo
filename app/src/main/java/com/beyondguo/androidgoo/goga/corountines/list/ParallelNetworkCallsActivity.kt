package com.beyondguo.androidgoo.goga.corountines.list

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondguo.androidgoo.data.api.ApiHelperImpl
import com.beyondguo.androidgoo.data.api.RetrofitBuilder
import com.beyondguo.androidgoo.data.local.DatabaseBuilder
import com.beyondguo.androidgoo.data.local.DatabaseHelperImpl
import com.beyondguo.androidgoo.data.model.ApiUser
import com.beyondguo.androidgoo.databinding.ActivityParallelNetworkCallsBinding
import com.beyondguo.androidgoo.goga.corountines.CorountineItem
import com.beyondguo.androidgoo.goga.corountines.base.ApiUserAdapter
import com.beyondguo.androidgoo.goga.corountines.base.UiState
import com.beyondguo.androidgoo.goga.corountines.base.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class ParallelNetworkCallsActivity : AppCompatActivity(), CorountineItem {

    private var _binding: ActivityParallelNetworkCallsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ApiUserAdapter
    private lateinit var viewModel: ParallelNetworkCallsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityParallelNetworkCallsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        setupViewModel()
        setupObserve()
    }

    private fun setupUi() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ApiUserAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(
           ApiHelperImpl(RetrofitBuilder.apiService),
            DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        ))[ParallelNetworkCallsViewModel::class.java]
    }

    private fun setupObserve() {
        viewModel.getUiState().observe(this){
            when(it){
                is UiState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    renderList(it.data)
                    binding.recyclerView.visibility = View.VISIBLE
                }
                is UiState.Loading -> {
                    binding.recyclerView.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
                }
                is UiState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, it.message, Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun renderList(users: List<ApiUser>){
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }
}