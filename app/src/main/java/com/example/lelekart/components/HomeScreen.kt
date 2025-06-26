package com.example.lelekart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lelekart.ui.theme.MainViewModel

@Composable
fun HomeScreen(modifier: Modifier, viewModel: MainViewModel = viewModel(), navController: NavController) {
    val banners = viewModel.banners
    val categories = viewModel.categories
    val products = viewModel.products
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())) {
        TopBar()
        CategoryView(categories = categories, navController = navController)
        BannerView(banners)
        Spacer(modifier = Modifier.padding(10.dp))
        DealOfDay(products = products)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text= "Products",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        ProductItemView(
            products = products
        )
    }
}

