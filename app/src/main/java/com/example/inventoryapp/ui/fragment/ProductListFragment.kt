package com.example.inventoryapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.adapter.ProductAdapter
import com.example.inventoryapp.ui.adapter.UserAdapter
import com.example.inventoryapp.retrofit.config.RetrofitInitializer
import com.example.inventoryapp.model.Product
import com.example.inventoryapp.model.User
import com.example.inventoryapp.ui.viewmodel.ProductListViewModel
import kotlinx.android.synthetic.main.fragment_product_list.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {

    private val viewModel by lazy {
        val provider = ViewModelProvider(this)
        provider.get(ProductListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbarPrincipal.title = "Inventario App"

        val products = ArrayList<Product>()
        arguments?.let {
            var product = ProductListFragmentArgs.fromBundle(it).product
            product.let {
                products.add(product)
            }
        }

        products.add(
            Product(
                null,
                "Chave de fenda",
                104,
                Date(),
                1,
                R.drawable.box
            )
        )
        products.add(
            Product(
                null,
                "Alicate",
                100,
                Date(),
                0,
                R.drawable.box
            )
        )

        val call = RetrofitInitializer().productService().getByName("")
        call.enqueue(object: Callback<List<Product>?>{
            override fun onResponse(call: Call<List<Product>?>,
                                    response: Response<List<Product>?>
            ) {
               response?.body()?.let {
                   val productList: List<Product> = it
                   configureListProduct(productList)
               }
            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }

        })



        floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_productList_to_productRegister)
        }

        super.onViewCreated(view, savedInstanceState)
    }
    private fun configureListProduct(products: List<Product>) {
        val myAdapter = ProductAdapter(products)

        recyclerView.layoutManager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL)

        recyclerView.adapter = myAdapter
    }
    private fun configureListUser(users: List<User>) {
        val myAdapter = UserAdapter(users)

        recyclerView.layoutManager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL)

        recyclerView.adapter = myAdapter
    }
}