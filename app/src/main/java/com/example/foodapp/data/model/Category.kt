package com.example.foodapp.data.model

data class Category (
    val id: Int,
    val name: String,
    val imageUrl: String,
    val items: List<Food>,
    val totalMenu: Int
)