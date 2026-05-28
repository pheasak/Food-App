package com.example.foodapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.Food
import com.example.foodapp.data.repository.FoodRepository
import com.example.foodapp.ui.state.FoodUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FoodViewModel: ViewModel() {
    private val repository = FoodRepository()

    private val _uiState = MutableStateFlow(FoodUiState())

    val uiState = _uiState.asStateFlow()

    init {
        // Initialize
        loadFoods()
        loadCategories()
    }

    private fun loadFoods(){

        _uiState.value = _uiState.value.copy(
            isLoading = true
        )

        _uiState.value  = _uiState.value .copy(
            foodList = repository.getFoods(),
            isLoading = false
        )
    }

    private fun loadCategories() {

        val foods = _uiState.value.foodList

        val burger = foods.filter { it.categoryName == "Burger" }
        val pizza = foods.filter { it.categoryName == "Pizza" }
        val seafood = foods.filter { it.categoryName == "Seafood" }
        val pasta = foods.filter { it.categoryName == "Pasta" }
        val drink = foods.filter { it.categoryName == "Drink" }
        val dessert = foods.filter { it.categoryName == "Dessert" }

        _uiState.value = _uiState.value.copy(

            categoryList = listOf(

                Category(
                    id = 1,
                    name = "Burger",
                    imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
                    totalMenu = burger.size,
                    items = burger
                ),

                Category(
                    id = 2,
                    name = "Pizza",
                    imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591",
                    totalMenu = pizza.size,
                    items = pizza
                ),

                Category(
                    id = 3,
                    name = "Seafood",
                    imageUrl = "https://images.unsplash.com/photo-1617196035154-1e1b79b3b5a7",
                    totalMenu = seafood.size,
                    items = seafood
                ),

                Category(
                    id = 4,
                    name = "Drink",
                    imageUrl = "https://images.unsplash.com/photo-1544145945-f90425340c7e",
                    totalMenu = drink.size,
                    items = drink
                ),

                Category(
                    id = 5,
                    name = "Dessert",
                    imageUrl = "https://images.unsplash.com/photo-1551024601-bec78aea704b",
                    totalMenu = dessert.size,
                    items = dessert
                ),

                Category(
                    id = 6,
                    name = "Pasta",
                    imageUrl = "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9",
                    totalMenu = pasta.size,
                    items = pasta
                )
            )
        )
    }

    fun selectFood(id:Int){
        _uiState.value  = _uiState.value .copy(
            selectedFood = repository.getFoodById(id)
        )
    }

    fun selectCategory(name: String){
        _uiState.value = _uiState.value.copy(
            selectedCategory = _uiState.value.categoryList.find { it.name == name }
        )
    }

    fun toggleFavorite(foodId: Int){
        val updatedFood = _uiState.value .foodList.map {
            food ->
                if(food.id == foodId){
                    food.copy(
                        isFavorite = !food.isFavorite
                    )
                }else{
                    food
                }
        }

        _uiState.value  = _uiState.value .copy(
            foodList = updatedFood
        )

        addFavoriteFood()
    }

    fun updateSearchQuery(query:String){
        _uiState.value  = _uiState.value .copy(
            searchQuery = query
        )
    }

    fun addFavoriteFood(){
        val foodsFilter = _uiState.value.foodList.filter { food -> food.isFavorite }
        _uiState.value = _uiState.value.copy(
            favoriteList = foodsFilter
        )
    }
}