package com.example.hiltdependencyinjection.respository

import com.example.hiltdependencyinjection.models.Product
import com.example.hiltdependencyinjection.retrofit.FakeApi
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkProductRepository @Inject constructor(private val fakeApi: FakeApi) {
    suspend fun getProducts(): Response<List<Product>> {
        return fakeApi.getProducts()
    }
}


