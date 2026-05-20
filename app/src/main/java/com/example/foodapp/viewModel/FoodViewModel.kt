package com.example.foodapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repository.FoodRepository
import com.example.foodapp.ui.state.FoodUiState

class FoodViewModel: ViewModel() {
    private val repository = FoodRepository()

    var uiState by mutableStateOf(FoodUiState())
        private set

    init {
        // Initialize
        loadFoods()
    }

    private fun loadFoods(){
        uiState = uiState.copy(
            foodList = repository.getFoods()
        )
    }

    fun selectFood(id:Int){
        uiState = uiState.copy(
            selectedFood = repository.getFoodById(id)
        )
    }

}