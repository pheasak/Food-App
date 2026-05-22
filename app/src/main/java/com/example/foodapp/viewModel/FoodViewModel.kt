package com.example.foodapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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

    fun selectFood(id:Int){
        _uiState.value  = _uiState.value .copy(
            selectedFood = repository.getFoodById(id)
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