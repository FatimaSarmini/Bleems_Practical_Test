package com.example.bleemspracticaltest.ui.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bleemspracticaltest.databinding.ActivityMainBinding
import com.example.bleemspracticaltest.model.Data
import com.example.bleemspracticaltest.model.FeaturedItem
import com.example.bleemspracticaltest.ui.screens.adapter.FeaturedItemAdapter
import com.example.bleemspracticaltest.ui.screens.adapter.ItemsAdapter
import com.example.bleemspracticaltest.ui.screens.adapter.ShimmerItemsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainLayout.visibility = VISIBLE
        fetchItems()

    }
    private fun fetchItems() {
        startFeaturedItemsShimmer()
        startItemsShimmer()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getAllItems()
        viewModel.observeFeaturedItems().observe(this, Observer { result ->
            fillFeaturedItems(result)
            binding.contentFeaturedItemsLayout.shimmerFeaturedItemsLayout.stopShimmer()
            binding.contentFeaturedItemsLayout.shimmerFeaturedItemsLayout.visibility = GONE
            binding.contentFeaturedItemsLayout.recyclerFeaturedItems.visibility = VISIBLE
        })

        viewModel.observeItems().observe(this, Observer { result ->
            fillItemsList(result)
            binding.contentItemsListLayout.shimmerItemsListLayout.stopShimmer()
            binding.contentItemsListLayout.shimmerItemsListLayout.visibility = GONE
            binding.contentItemsListLayout.recyclerItemsList.visibility = VISIBLE
        })
    }

    private fun fillFeaturedItems(result: List<FeaturedItem>) {
        binding.contentFeaturedItemsLayout.recyclerFeaturedItems .layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.contentFeaturedItemsLayout.recyclerFeaturedItems.adapter = FeaturedItemAdapter(result)
    }


    private fun fillItemsList(result: List<Data>) {
        binding.contentItemsListLayout.recyclerItemsList .layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.contentItemsListLayout.recyclerItemsList.adapter = ItemsAdapter(result)
    }

    private fun startFeaturedItemsShimmer() {
        binding.contentFeaturedItemsLayout.recyclerFeaturedItems.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.contentFeaturedItemsLayout.recyclerFeaturedItems.adapter = ShimmerItemsAdapter(arrayListOf("One", "Two", "Three"))
        binding.contentFeaturedItemsLayout.shimmerFeaturedItemsLayout.startShimmer()
        binding.contentFeaturedItemsLayout.shimmerFeaturedItemsLayout.visibility = View.VISIBLE
        binding.contentFeaturedItemsLayout.recyclerFeaturedItems.visibility = View.GONE
    }

    private fun startItemsShimmer() {
        binding.contentItemsListLayout.recyclerItemsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.contentItemsListLayout.recyclerItemsList.adapter = ShimmerItemsAdapter(arrayListOf("One", "Two", "Three"))
        binding.contentItemsListLayout.shimmerItemsListLayout.startShimmer()
        binding.contentItemsListLayout.shimmerItemsListLayout.visibility = View.VISIBLE
        binding.contentItemsListLayout.recyclerItemsList.visibility = View.GONE
    }
}