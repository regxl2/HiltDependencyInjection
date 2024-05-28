package com.example.hiltdependencyinjection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hiltdependencyinjection.ui.theme.HiltDependencyInjectionTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

const val TAG = "HiltLearn"

// for DI, class other than application we will use @AndroidEntryPoint annotation
// Note, for example if we are using fragment inside the activity and injecting the
// userRepository class into fragment not in the activity , then also we have annotate
// the activity with @AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // Field Injection

    @SqlQualifier
    @Inject
    lateinit var sqlRepository: UserRepository

    @Named("firebase")
    @Inject
    lateinit var firebaseRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sqlRepository.saveUser("regxl", "regxl@gmail.com")
        firebaseRepository.saveUser("regxl", "regxl@gmail.com")
        setContent {
            HiltDependencyInjectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltDependencyInjectionTheme {
        Greeting("Android")
    }
}