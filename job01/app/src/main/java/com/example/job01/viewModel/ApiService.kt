package com.example.job01.viewModel


import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts():List<Product>

}