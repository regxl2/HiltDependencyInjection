package com.example.hiltdependencyinjection.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hiltdependencyinjection.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FakeDb: RoomDatabase(){
    abstract fun getFakeDao(): FakeDao
}