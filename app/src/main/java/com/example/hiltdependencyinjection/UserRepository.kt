package com.example.hiltdependencyinjection

import android.util.Log
import javax.inject.Inject

interface UserRepository{
    fun saveUser(name: String, email: String)
}

// for @Binds we need @Inject annotation for creation of the object
class SQLRepository: UserRepository{
    override fun saveUser(name: String, email: String) {
        Log.d(TAG, "SQlRepository: saved the user with name: $name, email: $email")
    }
}

// for @Provides annotation @Inject is not needed for the creation of the object.
class FirebaseRepository: UserRepository{
    override fun saveUser(name: String, email: String) {
        Log.d(TAG, "FirebaseRepository: saved the user with name: $name, email: $email")
    }
}