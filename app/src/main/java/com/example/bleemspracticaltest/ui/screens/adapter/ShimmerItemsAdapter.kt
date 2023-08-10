package com.example.bleemspracticaltest.ui.screens.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bleemspracticaltest.databinding.ItemFeaturedShimmerBinding

class ShimmerItemsAdapter(private val items: List<String>)
    : RecyclerView.Adapter<ShimmerItemsAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: ItemFeaturedShimmerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemFeaturedShimmerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

    }

}