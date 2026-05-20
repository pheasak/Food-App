package com.example.foodapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodapp.ui.screen.DetailScreen
import com.example.foodapp.ui.screen.HomeScreen
import com.example.foodapp.ui.theme.FoodAppTheme
import com.example.foodapp.viewModel.FoodViewModel


enum class FoodScreen( val title:String){
    HOME(title = "Home"),
    DETAIL("Detail")
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAppTheme {
                FoodApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodApp( modifier: Modifier = Modifier,navController: NavHostController = rememberNavController()) {

    val viewModel: FoodViewModel = viewModel()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FoodScreen.valueOf(backStackEntry?.destination?.route ?: FoodScreen.HOME.name)
    Scaffold(modifier = Modifier.fillMaxSize(),topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = currentScreen.title)
            },
            navigationIcon = {
                if (navController.previousBackStackEntry!=null){
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            }
        )
    },) { innerPadding ->

        NavHost(modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = FoodScreen.HOME.name
            ){
            composable(
                route = FoodScreen.HOME.name
            ){
                HomeScreen(viewModel, onClick = {
                    viewModel.selectFood(it)
                    navController.navigate(route = FoodScreen.DETAIL.name)
                })
            }

            composable(route = FoodScreen.DETAIL.name){
                DetailScreen(
                    viewModel
                )
            }
        }

    }
}

