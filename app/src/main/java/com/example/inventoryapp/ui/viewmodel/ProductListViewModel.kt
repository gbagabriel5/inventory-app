package com.example.inventoryapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class ProductListViewModel : ViewModel(){
    init {
        Log.i("viewmodel", "criando viewmodel")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("viewmodel", "destruindo viewmodel")
    }
}