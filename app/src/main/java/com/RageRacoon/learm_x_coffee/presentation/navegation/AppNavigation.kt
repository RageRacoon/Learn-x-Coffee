package com.RageRacoon.learm_x_coffee.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.RageRacoon.learm_x_coffee.LogInScreen
import com.RageRacoon.learm_x_coffee.MainScreen
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.SplashScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.EditProfileScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileScreen
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
            SignUpScreen(navController)
        }
        composable(route = AppScreen.ProfileScreen.rutaPantalla){
            ProfileScreen(navController)
        }
        composable(route = AppScreen.MainScreen.rutaPantalla){
            MainScreen(navController)
        }
        //Comunicacion entre pantallas, es necesario, comunicarse entre pantallas, gracias al navHostControler
        composable(
            route = AppScreen.EditProfileScreen.rutaPantalla,
            arguments = listOf(navArgument("user"){
                type = NavType.StringType
            })
        ){
            it.arguments?.getString("user")?.let {
                EditProfileScreen(navController, user = it)
            }

        }

        composable(route = AppScreen.NewTaskScreen.rutaPantalla){
            NewTaskScreen(navController)
        }

    }
}