package com.example.lelekart.data

data class ProductModel(
    val approved: Boolean,
    val category: String,
    val createdAt: String,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val salePrice: Int,
    val sellerId: Int,
    val stock: Int,
)
