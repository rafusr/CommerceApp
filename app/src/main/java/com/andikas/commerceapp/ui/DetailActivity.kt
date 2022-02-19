package com.andikas.commerceapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andikas.commerceapp.databinding.ActivityDetailBinding
import com.andikas.commerceapp.model.Product
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val extraProduct = intent.getParcelableExtra<Product>("extraProduct")!!

        Glide.with(this)
            .load(extraProduct.imageUrl)
            .centerCrop()
            .into(binding.imgDetailProduct)
        binding.txtTopDetailTitle.text = extraProduct.name
        binding.txtDetailTitle.text = extraProduct.name
        binding.ratingDetailProduct.rating = extraProduct.rating
        binding.txtDetailPrice.text = extraProduct.price
        binding.txtDetailShown.text = extraProduct.shown
        binding.txtDetailStyle.text = extraProduct.style
        binding.txtDetailDescription.text = extraProduct.description

        binding.btnDetailBack.setOnClickListener{
            onBackPressed()
        }
    }
}