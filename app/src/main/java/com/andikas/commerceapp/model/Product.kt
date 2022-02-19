package com.andikas.commerceapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val imageUrl: String,
    val rating: Float,
    val price: String,
    val priceCut: String,
    val priceDiscount: Int,
    val shown: String,
    val style: String,
    val description: String
) : Parcelable
