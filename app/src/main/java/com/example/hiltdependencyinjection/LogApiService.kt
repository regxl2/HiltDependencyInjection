package com.example.hiltdependencyinjection

import android.util.Log
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

// if i use @Singleton annotation then,  only one object will created at application level.
// for @ActivityScoped then, only one object will be created at Activity level.
// for @FragmentScoped then, only one object will be created at fragment level
@ActivityScoped
class LogApiService @Inject constructor() {
    fun log(message: String){
        Log.d(TAG, message)
    }
}