package com.example.inventoryapp.model

import java.io.Serializable
import java.util.*

class Product(val name: String,
              val quantity: Int,
              val date: Date,
              val status: Int,
              val image: Int) : Serializable
{
}