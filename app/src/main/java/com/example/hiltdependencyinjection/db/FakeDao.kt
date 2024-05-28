package com.example.hiltdependencyinjection.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hiltdependencyinjection.models.Product

@Dao
interface FakeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("select * from product")
    suspend fun getProducts(): List<Product>
}