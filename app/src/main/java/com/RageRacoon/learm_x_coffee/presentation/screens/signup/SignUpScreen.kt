package com.RageRacoon.learm_x_coffee.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SignUpTopBar
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SinUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
                 SignUpTopBar(navController)
        },
        content = {
                 SinUpContent(navController)
        },
        bottomBar = {}

    )
}