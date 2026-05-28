package com.example.foodapp.ui.screen

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.Food
import com.example.foodapp.viewModel.FoodViewModel

@Composable
fun HomeScreen(
    viewModel: FoodViewModel,
    onClick: (Int) -> Unit,
    onFavoriteButtonClicked: (Int) -> Unit,
    onClickCategory: (Category) -> Unit,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    val foods = uiState.foodList.filter {
        it.name.contains(uiState.searchQuery, ignoreCase = true)
    }

    val categories = uiState.categoryList

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {

        // Search
        item {
            OutlinedTextField(
                value = uiState.searchQuery,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onValueChange = {
                    viewModel.updateSearchQuery(it)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = "Search Food")
                }
            )
        }

        // Spacer
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        // Banner
        item {
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary)
            ){
                Image(
                    painter = rememberAsyncImagePainter("https://files.selar.co/product-images/2024/products/richidmultimedia/food-banner-design-selar.co-66662ea9afe5b.jpg"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Category Header
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Food Category",
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "View All",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Category List
        items(categories) { category ->
            CategoryCard(category = category, onClick = onClickCategory )
        }

        // Recommend Header
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Recommend",
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = "View All",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Loading
        if (uiState.isLoading) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        } else {

            // Food List
            items(foods) { food ->
                FoodCard(
                    food = food,
                    onClick = onClick,
                    onFavoriteButtonClicked = onFavoriteButtonClicked
                )
            }
        }

        // Bottom Space
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Composable
fun CategoryCard(category: Category,onClick: (Category) -> Unit){
    Card(
        onClick = {
            onClick(category)
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ),
//        onClick = {
//
//        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row() {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(topStart = 18.dp)).background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {
               Image(
                   painter = rememberAsyncImagePainter(category.imageUrl),
                   contentDescription = category.name,
                   contentScale = ContentScale.Crop,
                   modifier = Modifier.fillMaxSize()
               )

            }
            Column(
                modifier = Modifier.padding(16.dp).fillMaxHeight().weight(1f)
            ) {
                Text(
                    text = category.name,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${category.totalMenu} Menu",
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Filled.ArrowForwardIos,
                contentDescription = null,
                modifier = Modifier.align(
                    alignment = Alignment.CenterVertically
                ).padding(end = 16.dp)
            )
        }
    }
}

@Composable
fun FoodCard(food: Food,onClick: (Int)-> Unit,
             onFavoriteButtonClicked: (Int)-> Unit){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        shape = RoundedCornerShape(18.dp),
        onClick = {
            onClick(food.id)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    val foodViewModel: FoodViewModel = viewModel()
    HomeScreen(
        viewModel = foodViewModel,
        onClick = {

        },
        onFavoriteButtonClicked = {},
        onClickCategory = {}
    )
}