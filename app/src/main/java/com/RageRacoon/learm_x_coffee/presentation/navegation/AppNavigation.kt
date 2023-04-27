package com.RageRacoon.learm_x_coffee.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.RageRacoon.learm_x_coffee.LogInScreen
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.SplashScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SignUpScreen

@Composable
fun AppNavegation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = AppScreen.SplashScreen.rutaPantalla)
    {
        composable(route = AppScreen.SplashScreen.rutaPantalla){
            SplashScreen(navController)
        }
        composable(route = AppScreen.LogInScreen.rutaPantalla){
            LogInScreen(navController)
        }
        composable(route = AppScreen.SignUpScreen.rutaPantalla){
            SignUpScreen()
        }
    }
}