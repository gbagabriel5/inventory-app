package com.example.inventoryapp.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.model.Product
import kotlinx.android.synthetic.main.card_view.view.*

class ProductAdapter(val productsList: ArrayList<Product>,
                     val context: Context) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(product: Product) {
            itemView.txtNome.text = product.name
            itemView.txtQtde.text = product.quantity.toString()
            itemView.txtStatus.text = product.status
            itemView.txtData.text = product.date
            itemView.txtHora.text = product.hour
            itemView.imageView.setImageResource(product.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}