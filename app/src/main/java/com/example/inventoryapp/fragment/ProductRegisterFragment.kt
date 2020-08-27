package com.example.inventoryapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.inventoryapp.R
import com.example.inventoryapp.model.Product
import kotlinx.android.synthetic.main.fragment_product_register.*
import kotlinx.android.synthetic.main.toolbar.*
import java.util.*

class ProductRegisterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbarPrincipal.title = "Cadastro de Produto"

        btnSalvar.setOnClickListener(View.OnClickListener {
            var status = 0
            var id: Int = radioGroup.checkedRadioButtonId
            when {
                id == radio0.id -> {
                    status = 0
                }
                id == radio1.id -> {
                    status = 1
                }
                else -> {
                    Toast.makeText(context, "Selecione um Status!", Toast.LENGTH_SHORT).show()
                }
            }
            val product = Product(
                txtRegisterNome.text.toString(),
                txtRegisterQtde.text.toString().toInt(),
                Date(),
                status,
                R.drawable.box
            )

            val action = ProductRegisterFragmentDirections.actionProductRegisterToProductList(product)
            it.findNavController().navigate(action)
        })
        super.onViewCreated(view, savedInstanceState)
    }
}