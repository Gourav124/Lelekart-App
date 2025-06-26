package com.example.lelekart.services

import com.example.lelekart.data.Banner
import com.example.lelekart.data.CategoryModel
import com.example.lelekart.data.ProductModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/banners")
    suspend fun getBanners(): List<Banner>

    @GET("api/products")
    suspend fun getProducts(
        @Query("category") category: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 12,
        @Query("sellerId") sellerId: Int? = null,
        @Query("approved") approved: Boolean? = null
    ): ProductsResponse

    @GET("api/categories")
    suspend fun getCategories(): List<CategoryModel>
}

data class ProductsResponse(
    val products: List<ProductModel>,
    val total: Int,
    val page: Int,
    val limit: Int,
    val totalPages: Int
)