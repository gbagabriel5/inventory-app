package com.example.inventoryapp.retrofit.service

import com.example.inventoryapp.model.Product
import retrofit2.Call
import retrofit2.http.*

interface ProductService {
    @GET("/product/getByName")
    fun getByName(@Query(value = "name") name: String): Call<List<Product>>

    @POST("/product")
    fun create(@Body product: Product): Call<Product>

    @PUT("/product")
    fun update(@Body product: Product): Call<Product>
}