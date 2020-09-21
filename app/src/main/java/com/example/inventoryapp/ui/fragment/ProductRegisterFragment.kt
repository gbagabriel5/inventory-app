package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.inventoryapp.R
import com.example.inventoryapp.model.Product
import com.example.inventoryapp.retrofit.config.RetrofitInitializer
import kotlinx.android.synthetic.main.fragment_product_register.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbarPrincipal.title = "Cadastro de Produto"

        btnSalvar.setOnClickListener(View.OnClickListener {view
            var id: Int = radioGroup.checkedRadioButtonId
            var status = if(id.equals(radio1)) 1 else if (id.equals(radio0)) 0 else id

            var nome: String? = txtRegisterNome.text.toString()
            var qtde: String? = txtRegisterQtde.text.toString()

            nome?.let {
                qtde?.let {
                    if (status > -1) {
                        val product = Product(
                            null,
                            txtRegisterNome.text.toString(),
                            txtRegisterQtde.text.toString().toInt(),
                            null,
                            status
                        )

                        val call = RetrofitInitializer().productService().create(product)
                        call.enqueue(object: Callback<Product?> {
                            override fun onResponse(call: Call<Product?>,
                                                    response: Response<Product?>
                            ) {
                                response?.body()?.let {
                                    val product: Product = it
                                }
                            }
                            override fun onFailure(call: Call<Product?>, t: Throwable) {
                                Log.e("onFailure error", t?.message)
                            }
                        })

                        val action = ProductRegisterFragmentDirections.
                            actionProductRegisterToProductList()
                        view.findNavController().navigate(action)
                    } else {
                        Toast.makeText(context, "Selecione um status!", Toast.LENGTH_LONG)
                            .show()
                    }
                }?:kotlin.run {
                    Toast.makeText(context, "Digite a quantidade do produto!", Toast.LENGTH_LONG).show()
                }
            }?:kotlin.run {
                Toast.makeText(context, "Digite o nome do produto!", Toast.LENGTH_LONG).show()
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }
}