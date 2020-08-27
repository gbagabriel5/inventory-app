package com.example.inventoryapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.inventoryapp.R
import com.example.inventoryapp.adapter.ProductAdapter
import com.example.inventoryapp.model.Product
import kotlinx.android.synthetic.main.fragment_product_list.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [ProductListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val products = ArrayList<Product>()
        arguments?.let {
            var product = ProductListFragmentArgs.fromBundle(it).product
            product.let {
                products.add(product)
            }
        }

        products.add(
            Product(
                "Chave de fenda",
                104,
                Date(),
                1,
                R.drawable.box
            )
        )
        products.add(
            Product(
                "Alicate",
                100,
                Date(),
                0,
                R.drawable.box
            )
        )

        val myAdapter = ProductAdapter(products)

        recyclerView.layoutManager = StaggeredGridLayoutManager(
            1,
            StaggeredGridLayoutManager.VERTICAL)

        recyclerView.adapter = myAdapter


        btnRegistrar.setOnClickListener(View.OnClickListener {
           it.findNavController().navigate(R.id.action_productList_to_productRegister)
        })
        super.onViewCreated(view, savedInstanceState)
    }
}