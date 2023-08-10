package com.example.bleemspracticaltest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    val api : FlowerApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://884a2603-1fae-4203-8f48-067456afd15b.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FlowerApi::class.java)
    }
}