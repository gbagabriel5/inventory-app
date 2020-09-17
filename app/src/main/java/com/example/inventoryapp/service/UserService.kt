package com.example.inventoryapp.service

import com.example.inventoryapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("/user/getByName")
    fun getByName(): Call<List<User>>
}