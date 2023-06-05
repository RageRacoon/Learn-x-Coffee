package com.RageRacoon.learm_x_coffee

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.*
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.GetEvents
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.MyHabitBox

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
            MainTopBar(navController)
        },
        content = {
            GetEvents()
        },
        bottomBar = {
            MainBottomBar(navController)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ShowMainScreemPreview(){
}