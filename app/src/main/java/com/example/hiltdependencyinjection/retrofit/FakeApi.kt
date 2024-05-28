package com.example.hiltdependencyinjection.retrofit

import com.example.hiltdependencyinjection.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}