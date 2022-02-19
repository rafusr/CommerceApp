package com.andikas.commerceapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.andikas.commerceapp.adapter.ProductAdapter
import com.andikas.commerceapp.databinding.FragmentHomeBinding
import com.andikas.commerceapp.model.Product
import com.andikas.commerceapp.ui.DetailActivity
import com.andikas.commerceapp.utils.DataDummy
import com.andikas.commerceapp.utils.GridSpacingItemDecoration

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productAdapter = ProductAdapter(DataDummy.generateDummyProduct())
        binding.recyclerProduct.apply {
            layoutManager = GridLayoutManager(view.context, 2)
            setHasFixedSize(true)
            adapter = productAdapter
            addItemDecoration(
                GridSpacingItemDecoration(
                    2,
                    (resources.displayMetrics.density * 13).toInt(),
                    (resources.displayMetrics.density * 12).toInt()
                )
            )
        }
        productAdapter.setOnClickListener(object : ProductAdapter.ProductClickListener {
            override fun onClick(product: Product) {
                val intent = Intent(view.context, DetailActivity::class.java)
                    .putExtra("extraProduct", product)
                startActivity(intent)
            }
        })
    }
}