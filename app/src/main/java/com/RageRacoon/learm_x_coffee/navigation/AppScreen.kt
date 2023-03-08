package com.RageRacoon.learm_x_coffee.navigation

sealed class AppScreen (val rutaPantalla:String) {
    object SplashScreen: AppScreen("splash_screen")
    object MainScreen: AppScreen("main_screen")


}