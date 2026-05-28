package com.example.foodapp.data.model

data class Food(
    val id: Int,
    val name: String,
    val categoryId: Int,
    val description:String,
    val price: Double,
    val categoryName:String,
    val imageUrl: String,
    val isFavorite: Boolean = false,
)