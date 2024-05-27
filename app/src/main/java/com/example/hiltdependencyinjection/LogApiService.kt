package com.example.hiltdependencyinjection

import android.util.Log
import javax.inject.Inject

class LogApiService @Inject constructor() {
    fun log(message: String){
        Log.d(TAG, message)
    }
}