package com.example.hiltdependencyinjection

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


// For DI, you always need to make Custom application which inherits Application
// which will be parent scope for all other scope and dependency available in parent
// wil be available to its child.
// for DI, the code generation of the DI will start from this application class
// and we will annotate application class with @HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application(){
//    @Inject
//    lateinit var userRepository: UserRepository
    override fun onCreate() {
        super.onCreate()
//        userRepository.getMessage()
    }
}