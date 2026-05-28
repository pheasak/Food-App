package com.example.foodapp.ui.state

import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.Food

data class FoodUiState(
    val foodList:List<Food> =emptyList(),
    val favoriteList: List<Food> = emptyList(),
    val categoryList: List<Category> = emptyList(),
    val selectedFood: Food? = null,
    val selectedCategory: Category? = null,
    val searchQuery: String = "",
    val isLoading: Boolean = false
)