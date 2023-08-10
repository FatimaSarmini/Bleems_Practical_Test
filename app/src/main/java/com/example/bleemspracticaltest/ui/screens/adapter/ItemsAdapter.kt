package com.example.bleemspracticaltest.ui.screens.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.bleemspracticaltest.R
import com.example.bleemspracticaltest.databinding.ItemBinding
import com.example.bleemspracticaltest.model.Data

class ItemsAdapter(
private val items: List<Data>
) : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    class ItemsViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val binding =
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]
        val context = (holder.itemView.context as Activity)
        Glide.with(context).load(item.pic).apply(RequestOptions.errorOf(R.drawable.ic_pic_placeholder_24)).into(holder.binding.imgItem)
        holder.binding.txtName.text = item.item_name
        if (item.same_day_delivery) {
            holder.binding.txtSameDayDelivery.visibility = VISIBLE
            holder.binding.imgTextBackground.visibility = VISIBLE
        } else {
            holder.binding.txtSameDayDelivery.visibility = INVISIBLE
            holder.binding.imgTextBackground.visibility = INVISIBLE
        }
        holder.binding.txtPrice.text = item.price

    }

}