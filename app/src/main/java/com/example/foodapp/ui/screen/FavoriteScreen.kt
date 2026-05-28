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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.foodapp.data.model.Food
import com.example.foodapp.viewModel.FoodViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FoodViewModel,
    onClick: (Int) -> Unit,){
    val uiState by viewModel.uiState.collectAsState()
    val foods = uiState.favoriteList
    LazyColumn(
        modifier = modifier
    ) {
        items(items = foods) { food ->
            FoodCard(food,
                onClick = onClick,
                onFavoriteButtonClicked = {
                viewModel.toggleFavorite(it)
            })

        }
    }
}

@Composable
fun FoodFavoriteCard(
    food: Food, onClick: (Int) -> Unit,
    onFavoriteButtonClicked: (Int) -> Unit,
){
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
                    .padding(start = 10.dp,)
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

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = food.name)

                    IconButton(
                        onClick = {
                            onFavoriteButtonClicked(food.id)
                        },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Icon(
                            imageVector = if(food.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = "favorite"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = food.description)
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = food.categoryName)

                    Text(text = "$${food.price}")
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FavoritePreviewScreen(){
    val viewModel: FoodViewModel = viewModel()
    FavoriteScreen(onClick = {}, viewModel = viewModel)
}