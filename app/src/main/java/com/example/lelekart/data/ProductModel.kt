package com.example.lelekart.data

data class ProductModel(
    val id: String = "",
    val name: String = "",
    val imageUrl: List<String> = emptyList(),
    val description : String = "",
    val price: String = ""
)
