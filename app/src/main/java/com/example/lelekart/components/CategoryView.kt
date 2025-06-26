package com.example.lelekart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lelekart.data.CategoryModel

@Composable
fun CategoryView(categories: List<CategoryModel>, navController: NavController) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
           // .background(Color.White)
            .padding(vertical = 8.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        items(categories) { item ->
            Column(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .background(Color(0xFFFFF0E0), RoundedCornerShape(12.dp))
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("category_screen/${item.name}")
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = item.image,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp).clip(CircleShape)
                )
                Text(text = item.name, fontSize = 12.sp, color = Color(0xFFFF9800))
            }
           }
        }
    }