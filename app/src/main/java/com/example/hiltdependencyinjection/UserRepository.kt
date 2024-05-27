package com.example.hiltdependencyinjection

import android.util.Log

interface UserRepository{
    fun saveUser(name: String, email: String)
}

class SQLRepository: UserRepository{
    override fun saveUser(name: String, email: String) {
        Log.d(TAG, "SQlRepository: saved the user with name: $name, email: $email")
    }
}
class FirebaseRepository: UserRepository{
    override fun saveUser(name: String, email: String) {
        Log.d(TAG, "FirebaseRepository: saved the user with name: $name, email: $email")
    }
}