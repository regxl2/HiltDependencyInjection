package com.example.hiltdependencyinjection.respository

import com.example.hiltdependencyinjection.db.FakeDb
import com.example.hiltdependencyinjection.models.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseProductRepository@Inject constructor(private val fakeDb: FakeDb) {
    suspend fun insertProducts(productList: List<Product>){
        fakeDb.getFakeDao().addProducts(productList)
    }
}