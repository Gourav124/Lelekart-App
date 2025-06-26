package com.example.lelekart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lelekart.data.CategoryModel
import com.example.lelekart.ui.theme.GlobalNavigation
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

@Composable
fun CategoryView() {
    val categoriesList = remember {
        mutableStateOf<List<CategoryModel>>(emptyList())
    }
    LaunchedEffect(key1 = Unit) {
        Firebase.firestore.collection("data").document("stock")
            .collection("categories")
            .get().addOnCompleteListener() {
                if (it.isSuccessful) {
                    val resultList = it.result.documents.mapNotNull { doc ->
                        doc.toObject(CategoryModel::class.java)
                    }
                    categoriesList.value = resultList
                }

            }
    }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
           // .background(Color.White)
            .padding(vertical = 8.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        items(categoriesList.value) { item ->
               CategoryItem(category = item)
           }
        }
    }

@Composable
fun CategoryItem(category: CategoryModel){
    Button (
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFF3E0)
        ),
        onClick = { GlobalNavigation.navController.navigate("categories/" + category.id) },
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(36.dp)
    ) {
        Text(text = category.name, color = Color(0xFFEF6C00))
    }
}