package com.example.foodapp.data.repository

import com.example.foodapp.data.datasource.CategoryDataSource
import com.example.foodapp.data.datasource.FoodDataSource
import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.Food

class FoodRepository {
    fun getFoods(): List<Food> {
        return FoodDataSource.foods
    }

    fun getFoodById(id:Int): Food? {
        return FoodDataSource.foods.find { it.id == id }
    }

    fun getCategories(): List<Category>{
        return CategoryDataSource.categories
    }

    fun getCategoryById(id:Int): Category?{
        return CategoryDataSource.categories.find {
            it.id == id
        }
    }
}