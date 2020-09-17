package com.example.inventoryapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val cpf: String,
    val email: String
) : Serializable, Parcelable