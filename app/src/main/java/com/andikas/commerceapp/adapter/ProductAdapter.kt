package com.andikas.commerceapp.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andikas.commerceapp.databinding.ItemProductBinding
import com.andikas.commerceapp.model.Product
import com.bumptech.glide.Glide

class ProductAdapter(private val listProduct: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var productClickListener: ProductClickListener

    fun setOnClickListener(productClickListener: ProductClickListener) {
        this.productClickListener = productClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = listProduct[position]
        val discount = "${product.priceDiscount}%"

        Glide.with(holder.itemView)
            .load(product.imageUrl)
            .centerCrop()
            .into(holder.binding.imgProduct)
        holder.binding.txtTitle.text = product.name
        holder.binding.ratingProduct.rating = product.rating
        holder.binding.txtPrice.text = product.price
        holder.binding.txtStrikePrice.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            text = product.priceCut
        }
        holder.binding.txtDiscount.text = discount
        holder.itemView.setOnClickListener {
            productClickListener.onClick(product)
        }
    }

    override fun getItemCount(): Int = listProduct.size

    inner class ViewHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    interface ProductClickListener {
        fun onClick(product: Product)
    }
}