package com.example.lelekart.ui.theme

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lelekart.components.CategoryScreen
import com.example.lelekart.components.HomeScreen
import kotlin.getValue

@Composable
fun AppNavigation(viewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen(
                viewModel = viewModel,
                modifier = Modifier,
                navController = navController
            )
        }
        composable("category_screen/{categoryName}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            CategoryScreen(
                categoryName = categoryName,
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}
