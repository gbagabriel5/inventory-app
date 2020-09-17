package com.example.inventoryapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.R
import com.example.inventoryapp.model.User
import kotlinx.android.synthetic.main.card_view.view.*

class UserAdapter(private val userList: List<User>)
    : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindItems(user: User) {
            itemView.txtNome.text = user.name
            itemView.txtQtde.text = user.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return MyViewHolder(v)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}