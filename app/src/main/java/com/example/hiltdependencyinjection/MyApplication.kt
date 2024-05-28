package com.example.hiltdependencyinjection

import android.app.Application
import android.util.Log
import com.example.hiltdependencyinjection.retrofit.FakeApi
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Retrofit
import javax.inject.Inject


@HiltAndroidApp
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateApplication")
    }
}