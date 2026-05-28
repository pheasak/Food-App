package com.example.foodapp.data.datasource

import com.example.foodapp.data.model.Food

object FoodDataSource {
    val foods = listOf(

        Food(
            id = 1,
            categoryName = "Pizza",
            imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591",
            name = "Pepperoni Pizza",
            description = "Cheesy pepperoni pizza with fresh toppings.",
            categoryId = 1,
            price = 15.00
        ),

        Food(
            id = 2,
            categoryName = "Burger",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd",
            name = "Classic Burger",
            description = "Juicy beef burger with lettuce and cheese.",
            categoryId = 2,
            price = 12.00
        ),

        Food(
            id = 3,
            categoryName = "Dessert",
            imageUrl = "https://images.unsplash.com/photo-1551024601-bec78aea704b",
            name = "Chocolate Donut",
            description = "Soft donut topped with chocolate glaze.",
            price = 8.00,
            categoryId = 3
        ),

        Food(
            id = 4,
            categoryName = "Seafood",
            imageUrl = "https://images.unsplash.com/photo-1617196035154-1e1b79b3b5a7",
            name = "Salmon Sushi",
            description = "Fresh salmon sushi with premium rice.",
            price = 20.00,
            categoryId = 1,
        ),

        Food(
            id = 5,
            categoryName = "Drink",
            imageUrl = "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085",
            name = "Iced Coffee",
            description = "Cold brewed coffee with ice and milk.",
            price = 6.00,
            categoryId = 3,
        ),

        Food(
            id = 6,
            categoryName = "Pasta",
            imageUrl = "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9",
            name = "Spaghetti",
            description = "Italian spaghetti with tomato sauce.",
            price = 14.00,
            categoryId = 2,
        ),

        Food(
            id = 7,
            categoryName = "Pizza",
            imageUrl = "https://images.unsplash.com/photo-1594007654729-407eedc4be65",
            name = "Cheese Pizza",
            description = "Loaded cheese pizza with crispy crust.",
            price = 16.00,
            categoryId = 1,
        ),

        Food(
            id = 8,
            categoryName = "Dessert",
            imageUrl = "https://images.unsplash.com/photo-1488477181946-6428a0291777",
            name = "Ice Cream",
            description = "Vanilla ice cream with chocolate syrup.",
            price = 7.00,
            categoryId = 3,
        ),

        Food(
            id = 9,
            categoryName = "Burger",
            imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349",
            name = "Double Burger",
            description = "Double patty burger with extra cheese.",
            price = 18.00,
            categoryId = 2,
        ),

        Food(
            id = 10,
            categoryName = "Drink",
            imageUrl = "https://images.unsplash.com/photo-1513558161293-cdaf765ed2fd",
            name = "Orange Juice",
            description = "Fresh squeezed orange juice.",
            price = 5.00,
            categoryId = 3,
        ),

        Food(
            id = 11,
            categoryName = "Seafood",
            imageUrl = "https://images.unsplash.com/photo-1559847844-5315695dadae",
            name = "Grilled Shrimp",
            description = "Spicy grilled shrimp with herbs.",
            price = 22.00,
            categoryId = 1,
        ),

        Food(
            id = 12,
            categoryName = "Pasta",
            imageUrl = "https://images.unsplash.com/photo-1521389508051-d7ffb5dc8d96",
            name = "Carbonara",
            description = "Creamy carbonara with bacon.",
            price = 17.00,
            categoryId = 1,
        ),

        Food(
            id = 13,
            categoryName = "Dessert",
            imageUrl = "https://images.unsplash.com/photo-1563729784474-d77dbb933a9e",
            name = "Cupcake",
            description = "Sweet cupcake with strawberry cream.",
            price = 6.00,
            categoryId = 3
        ),

        Food(
            id = 14,
            categoryName = "Drink",
            imageUrl = "https://images.unsplash.com/photo-1544145945-f90425340c7e",
            name = "Milk Tea",
            description = "Refreshing milk tea with pearls.",
            price = 5.50,
            categoryId = 3
        ),

        Food(
            id = 15,
            categoryName = "Pizza",
            imageUrl = "https://images.unsplash.com/photo-1548365328-9f547fb0953b",
            name = "Veggie Pizza",
            description = "Healthy pizza loaded with vegetables.",
            price = 13.00,
            categoryId = 1
        ),

        Food(
            id = 16,
            categoryName = "Burger",
            imageUrl = "https://images.unsplash.com/photo-1572802419224-296b0aeee0d9",
            name = "Chicken Burger",
            description = "Crispy chicken burger with mayo.",
            price = 11.00,
            categoryId = 2
        ),

        Food(
            id = 17,
            categoryName = "Seafood",
            imageUrl = "https://images.unsplash.com/photo-1604908554165-e9464f5f4f0b",
            name = "Lobster Dish",
            description = "Premium lobster with garlic butter.",
            price = 35.00,
            categoryId = 1,
        ),

        Food(
            id = 18,
            categoryName = "Drink",
            imageUrl = "https://images.unsplash.com/photo-1517701604599-bb29b565090c",
            name = "Lemon Tea",
            description = "Cool lemon tea with mint flavor.",
            categoryId = 3,
            price = 4.50
        ),

        Food(
            id = 19,
            categoryName = "Pasta",
            imageUrl = "https://images.unsplash.com/photo-1473093295043-cdd812d0e601",
            name = "Lasagna",
            description = "Layered lasagna with rich meat sauce.",
            categoryId = 1,
            price = 19.00
        ),

        Food(
            id = 20,
            categoryName = "Dessert",
            imageUrl = "https://images.unsplash.com/photo-1509440159596-0249088772ff",
            name = "Croissant",
            description = "Fresh buttery croissant.",
            price = 5.00,
            categoryId = 3
        )
    )
}