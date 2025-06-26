package com.example.lelekart.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lelekart.components.CategoryScreen
import com.example.lelekart.components.HomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    GlobalNavigation.navController = navController

    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen(modifier = Modifier)
        }
        composable ("categories/{categoryId}"){
            var categoryId = it.arguments?.getString("categoryId")
            CategoryScreen(categoryId?:"")
        }
    }
}
object GlobalNavigation {
    lateinit var navController : NavHostController
}