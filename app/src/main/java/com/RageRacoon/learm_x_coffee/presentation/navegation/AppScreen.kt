package com.RageRacoon.learm_x_coffee.presentation.navegation

sealed class AppScreen (val rutaPantalla:String) {
    object SplashScreen: AppScreen("splash_screen")
    object MainScreen: AppScreen("main_screen")
    object LogInScreen: AppScreen("Log_in_screen")
    object SignUpScreen: AppScreen("Sin_up_screen")
    object ProfileScreen: AppScreen("Profile_screen")
    object EditProfileScreen: AppScreen("Edit_Profile_screen/{user}"){
        fun suminstrarUsuario(user: String) = "Edit_Profile_screen/${user}"
    }


}