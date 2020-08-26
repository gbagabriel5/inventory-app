package com.example.inventoryapp.adapter

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.model.Product
import kotlinx.android.synthetic.main.card_view.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ProductAdapter(private val productsList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindItems(product: Product) {
            itemView.txtNome.text = product.name
            itemView.txtQtde.text = product.quantity.toString()
            if(product.status == 0) {
                itemView.txtStatus.text = "Em andamento"
                itemView.cardStatus.setCardBackgroundColor(Color.parseColor("#F4A700"))
            } else {
                itemView.txtStatus.text = "Concluído"
                itemView.cardStatus.setCardBackgroundColor(Color.parseColor("#5CE023"))
            }

            val now = LocalDateTime.now()
            val date = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val dateFormatted = now.format(date)

            val hour = DateTimeFormatter.ofPattern("HH:mm")
            val hourFormatted = now.format(hour)

            itemView.txtData.text = dateFormatted
            itemView.txtHora.text = hourFormatted
            itemView.imageView.setImageResource(product.image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return MyViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(productsList[position])
    }

    override fun getItemCount(): Int {
        return productsList.size
    }
}