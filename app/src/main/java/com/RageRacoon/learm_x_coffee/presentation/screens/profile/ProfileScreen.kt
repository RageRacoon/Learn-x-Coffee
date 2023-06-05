package com.RageRacoon.learm_x_coffee.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
        },
        content = {
            ProfileContent(navController)
        },
        bottomBar = {
            ProfileBottomBar(navController)
        }
    )
}