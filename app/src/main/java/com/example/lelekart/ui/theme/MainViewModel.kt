package com.example.lelekart.ui.theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lelekart.data.Banner
import com.example.lelekart.data.CategoryModel
import com.example.lelekart.data.ProductModel
import com.example.lelekart.services.RetrofitClient
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    var banners by mutableStateOf<List<Banner>>(emptyList())
    var categories by mutableStateOf<List<CategoryModel>>(emptyList())
    var products by mutableStateOf<List<ProductModel>>(emptyList())
    var categoryProducts by mutableStateOf<List<ProductModel>>(emptyList())

    init {
        fetchAll()
    }

    fun fetchAll() {
        viewModelScope.launch {
            try {
                banners = RetrofitClient.api.getBanners()
                categories = RetrofitClient.api.getCategories()
                val productsResponse = RetrofitClient.api.getProducts()
                products = productsResponse.products
                Log.d("API_DATA", "Loaded: ${banners.size} banners, ${categories.size} categories, ${products.size} products")
            } catch (e: Exception) {
                Log.e("HomeVM", "Error: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    fun fetchProductsByCategory(categoryName: String) {
        viewModelScope.launch {
            try {
                val productsResponse = RetrofitClient.api.getProducts(category = categoryName)
                categoryProducts = productsResponse.products
                Log.d("CATEGORY_DATA", "Loaded ${categoryProducts.size} products for category: $categoryName")
            } catch (e: Exception) {
                Log.e("CategoryVM", "Error fetching category products: ${e.message}")
                e.printStackTrace()
                categoryProducts = emptyList()
            }
        }
    }
}