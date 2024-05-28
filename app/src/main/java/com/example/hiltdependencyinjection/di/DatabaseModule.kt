package com.example.hiltdependencyinjection.di

import android.content.Context
import androidx.room.Room
import com.example.hiltdependencyinjection.db.FakeDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun getFakeDb(@ApplicationContext context: Context): FakeDb {
        return Room.databaseBuilder(
            context = context,
            klass = FakeDb::class.java,
            name = "Fake Product Database"
        ).build()
    }
}