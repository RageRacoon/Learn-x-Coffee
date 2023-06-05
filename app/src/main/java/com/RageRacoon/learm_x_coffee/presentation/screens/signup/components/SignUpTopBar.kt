package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyTopBar

@Composable
fun SignUpTopBar(navController: NavHostController){
    MyTopBar(title = "Nuevo usuario", whitIcon = true, navController)
}