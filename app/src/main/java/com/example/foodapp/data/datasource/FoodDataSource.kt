package com.example.foodapp.data.datasource

import com.example.foodapp.data.model.Food

object FoodDataSource {
    val foods = listOf<Food>(
        Food(
            1,
            "Pizza",
            "Cheesy Italian food",
            12.99,
            "Fast Food",
            "https://images.unsplash.com/photo-1513104890138-7c749659a591"
        ),
        Food(
            2,
            "Burger",
            "American fast food",
            7.99,
            "Fast Food",
            "https://www.foodandwine.com/thmb/XE8ubzwObCIgMw7qJ9CsqUZocNM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/MSG-Smash-Burger-FT-RECIPE0124-d9682401f3554ef683e24311abdf342b.jpg"
        ),
        Food(
            3,
            "Sushi",
            "Japanese seafood dish",
            25.00 ,
            "Japan Food",
            "https://assets.tmecosys.cn/image/upload/t_web_rdp_recipe_584x480/img/recipe/ras/Assets/64EF898D-2EDD-4B47-A456-E6A7D137AC91/Derivates/00f76cac-64f6-4573-be4f-e604a7d99143.jpg"),
    )
}