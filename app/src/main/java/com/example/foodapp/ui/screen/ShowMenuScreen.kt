package com.example.foodapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.foodapp.data.model.Category
import com.example.foodapp.data.model.Food

@Composable
fun ShowMenuScreen(
    category: Category ?= null
){
    Column(
    modifier = Modifier.padding(16.dp)
    ) {
        CustomSearchTextField(
            value = "",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (category!=null){
        LazyColumn {

            itemsIndexed(category.items) { index, food ->

                ItemCard(food)
                // Divider
                if (index != category.items.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        thickness = 1.dp,
                        color = Color(0xFF2A2D4E)
                    )
                }
            }
        }
        }

    }
}

@Composable
fun ItemCard(
    food: Food
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 6.dp)
    ) {

        Row {

            Box(
                modifier = Modifier
                    .size(100.dp)

            ){
                Image(
                    painter = rememberAsyncImagePainter(food.imageUrl),
                    contentDescription = food.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(RoundedCornerShape(8.dp)).fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = food.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = food.description,
                    fontSize = 13.sp,
                    maxLines = 2
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "$${food.price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Button(
                        onClick = {},
                        modifier = Modifier.height(35.dp),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "Add Cart",
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomSearchTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = "Search...",
                color = Color.LightGray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.Gray
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(50.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,

            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,

            cursorColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(50.dp)
            )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowMenuScreenPreview(){
    ShowMenuScreen()
}