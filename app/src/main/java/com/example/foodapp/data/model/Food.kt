package com.example.foodapp.data.model

data class Food(
    val id: Int,
    val name: String,
    val description:String,
    val price: Double,
    val category:String,
    val imageUrl: String,
    val isFavorite: Boolean = false,
)
