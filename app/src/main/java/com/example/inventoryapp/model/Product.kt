package com.example.inventoryapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Product(
    val id: Int?,
    val name: String,
    val quantity: Int,
    val date: Long?,
    val status: Int

) : Serializable, Parcelable