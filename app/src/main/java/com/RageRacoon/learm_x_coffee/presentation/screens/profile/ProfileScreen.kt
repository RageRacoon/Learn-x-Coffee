package com.RageRacoon.learm_x_coffee.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LogInContent
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginTopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController : NavHostController) {
    Scaffold(
        topBar = {

        },
        content = {
            Text(text = "Su pesto perfil")
        },
        bottomBar = {
            LoginBottomBar(navController)
        }
    )
}