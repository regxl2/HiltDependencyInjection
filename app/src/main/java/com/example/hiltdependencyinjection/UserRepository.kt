package com.example.hiltdependencyinjection

import javax.inject.Inject

// Constructor Injection
class UserRepository @Inject constructor(private val logApiService: LogApiService){
    fun log(){
        logApiService.log("Hello World, my name is regxl")
    }
}