package com.example.bleemspracticaltest.network


import com.example.bleemspracticaltest.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface FlowerApi {
    @GET("testUrlVer1.1")
    fun getAll() : Call<ApiResponse>
}