package com.example.inventoryapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inventoryapp.R
import com.example.inventoryapp.adapter.ProductAdapter
import com.example.inventoryapp.model.Product
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_product_list)

        val products = ArrayList<Product>()
        products.add(Product(
            "Chave de fenda",
            104,
            "25/08/2020",
            "22:00",
            "Em andamento",
            R.drawable.box
        ))
        products.add(Product(
            "alicate",
            100,
            "25/08/2020",
            "20:00",
            "Em andamento",
            R.drawable.box
        ))

        val myAdapter = ProductAdapter(products, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter


    }
}