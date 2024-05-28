package com.example.hiltdependencyinjection.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltdependencyinjection.TAG
import com.example.hiltdependencyinjection.models.Product
import com.example.hiltdependencyinjection.respository.DatabaseProductRepository
import com.example.hiltdependencyinjection.respository.NetworkProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

sealed interface ProductState{
    data object Loading: ProductState
    data class Success(val productList: List<Product>): ProductState
    data object Error: ProductState
}

@HiltViewModel
class MainViewModel @Inject constructor(val networkProductRepository: NetworkProductRepository, private val databaseProductRepository: DatabaseProductRepository): ViewModel() {
    var state = mutableStateOf<ProductState>(ProductState.Loading)
        private set

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            val response: Response<List<Product>>
            withContext(Dispatchers.Default){
                delay(2000)
                response = networkProductRepository.getProducts()
                Log.d(TAG, "Data insert from network")
            }
            if(response.isSuccessful){
                response.body()?.let {
                    state.value = ProductState.Success(it)
                    withContext(Dispatchers.IO){
                        databaseProductRepository.insertProducts(it)
                        Log.d(TAG, "Data inserted into database")
                    }
                }
            }
            else{
                state.value = ProductState.Error
            }
        }
    }
}