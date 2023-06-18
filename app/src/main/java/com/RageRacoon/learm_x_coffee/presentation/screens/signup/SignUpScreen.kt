package com.RageRacoon.learm_x_coffee.presentation.screens.signup

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.Register
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SignUpBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SignUpTopBar
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SinUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController : NavHostController) {



    Scaffold(
        topBar = {
                 SignUpTopBar()
        },
        content = {
                 SinUpContent(navController)
        },
        bottomBar = {
            SignUpBottomBar(navController)
        }
    )
    Register(navController)
}