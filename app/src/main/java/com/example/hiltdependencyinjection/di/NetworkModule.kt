package com.example.hiltdependencyinjection.di

import com.example.hiltdependencyinjection.retrofit.FakeApi
import com.example.hiltdependencyinjection.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun provideFakeApi(retrofit: Retrofit): FakeApi{
        return retrofit.create(FakeApi::class.java)
    }
}