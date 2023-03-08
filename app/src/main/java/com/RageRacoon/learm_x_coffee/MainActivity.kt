package com.RageRacoon.learm_x_coffee

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
import com.RageRacoon.learm_x_coffee.navigation.AppNavegation
import com.RageRacoon.learm_x_coffee.ui.theme.LearmxCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearmxCoffeeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background)
                {
                    AppNavegation()
                }
            }
        }
    }
<<<<<<< HEAD
}

@Composable
fun Greeting(name: String) {
    LogInScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearmxCoffeeTheme {
        Greeting("Android")
    }
=======
>>>>>>> 2-0001-splash-sreen
}