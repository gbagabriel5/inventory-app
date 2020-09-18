package com.example.inventoryapp.retrofit.service

import com.example.inventoryapp.model.User
import retrofit2.Call
import retrofit2.http.*

interface UserService {
    @GET("/user/getByName")
    fun getByName(@Query(value = "name") name: String): Call<List<User>>

    @POST("/user")
    fun create(@Body user: User): Call<User>

    @PUT("/user")
    fun update(@Body user: User): Call<User>
}