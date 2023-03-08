package com.RageRacoon.learm_x_coffee.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.RageRacoon.learm_x_coffee.presentation.screens.AppScreen
import com.RageRacoon.learm_x_coffee.LogInScreen
import com.RageRacoon.learm_x_coffee.SplashScreen

@Composable
fun AppNavegation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreen.SplashScreen.rutaPantalla)
    {
        composable(AppScreen.SplashScreen.rutaPantalla){
            SplashScreen(navController)
        }
        composable(AppScreen.MainScreen.rutaPantalla){
            LogInScreen()
        }

    }
}