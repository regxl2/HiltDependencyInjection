package com.example.hiltdependencyinjection.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltdependencyinjection.viewmodels.MainViewModel
import com.example.hiltdependencyinjection.viewmodels.ProductState

@Composable
fun MainScreen(modifier: Modifier = Modifier, viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val productState = viewModel.state
    Text(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        text = getProductText(productState.value),
        textAlign = TextAlign.Center
    )
}

fun getProductText(productState: ProductState): String{
    return when(productState){
        is ProductState.Loading -> "Loading..."
        is ProductState.Success -> productState.productList.toString()
        is ProductState.Error -> "Something went wrong"
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    MainScreen()
}