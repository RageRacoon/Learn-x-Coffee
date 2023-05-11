package com.RageRacoon.learm_x_coffee.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.RageRacoon.learm_x_coffee.LogInScreen
import com.RageRacoon.learm_x_coffee.presentation.navigation.AppNavegation
import com.RageRacoon.learm_x_coffee.presentation.ui.theme.LearmxCoffeeTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearmxCoffeeTheme (darkTheme = false){
                // A surface container using the 'background' color from the theme \
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background)
                {
                    AppNavegation()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearmxCoffeeTheme {
        Greeting("Android")
    }
}