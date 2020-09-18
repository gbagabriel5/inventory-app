package com.example.inventoryapp.retrofit.config

import com.example.inventoryapp.retrofit.service.ProductService
import com.example.inventoryapp.retrofit.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://172.21.4.17:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userService() = retrofit.create(UserService::class.java)

    fun productService() = retrofit.create(ProductService::class.java)

}