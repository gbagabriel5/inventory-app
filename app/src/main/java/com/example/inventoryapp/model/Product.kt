package com.example.inventoryapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
class Product(val name: String,
              val quantity: Int,
              val date: Date,
              val status: Int,
              val image: Int) : Serializable, Parcelable {
}