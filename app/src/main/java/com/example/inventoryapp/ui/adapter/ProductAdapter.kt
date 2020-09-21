package com.example.inventoryapp.ui.adapter

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
import java.util.*

class ProductAdapter(private val productsList: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

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

            //Get instance of calendar
            val calendar = Calendar.getInstance(Locale.getDefault())
            //get current date from ts
            calendar.timeInMillis = product.date!!
            //return formatted date
            val data =  android.text.format.DateFormat.format("dd-MM-yyyy", calendar).toString()
            val hora = android.text.format.DateFormat.format("HH:mm", calendar).toString()
            itemView.txtData.text = data
            itemView.txtHora.text = hora

            itemView.imageView.setImageResource(R.drawable.box)

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