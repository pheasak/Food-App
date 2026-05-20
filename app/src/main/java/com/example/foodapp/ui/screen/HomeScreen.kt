package com.example.foodapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.foodapp.data.model.Food
import com.example.foodapp.viewModel.FoodViewModel

@Composable
fun HomeScreen(
    viewModel: FoodViewModel,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    val foods = viewModel.uiState.foodList
    LazyColumn(
        modifier = modifier
    ) {
        items(items = foods){
            food -> FoodCard(food, onClick = onClick)

        }
    }
}

@Composable
fun FoodCard(food: Food,onClick: (Int)-> Unit){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        onClick = {
            onClick(food.id)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .padding(start =10.dp, )
                    .clip(RoundedCornerShape(8.dp))
            ) {

                Image(
                    painter = rememberAsyncImagePainter(food.imageUrl),
                    contentDescription = food.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .padding(16.dp),

            ) {

                Text(text = food.name)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = food.description)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = food.category)

                    Text(text = "$${food.price}")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    val foodViewModel: FoodViewModel = viewModel()
    HomeScreen(
        viewModel = foodViewModel,
        onClick = {

        }
    )
}