package com.example.bleemspracticaltest.ui.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bleemspracticaltest.model.ApiResponse
import com.example.bleemspracticaltest.model.Data
import com.example.bleemspracticaltest.model.FeaturedItem
import com.example.bleemspracticaltest.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private var featuredItems = MutableLiveData<List<FeaturedItem>>()
    private var items = MutableLiveData<List<Data>>()
    fun getAllItems() {
        RetrofitInstance.api.getAll().enqueue(object  : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.body()!=null){
                    featuredItems.value = response.body()!!.result.featured_items
                    items.value = response.body()!!.result.data
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeFeaturedItems() : LiveData<List<FeaturedItem>> {
        return featuredItems
    }
    fun observeItems() : LiveData<List<Data>> {
        return items
    }

}