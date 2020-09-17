package com.example.inventoryapp.config

import com.example.inventoryapp.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.21.4.17:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun productService() = retrofit.create(UserService::class.java)

}