package com.RageRacoon.learm_x_coffee.presentation.screens.my_events

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components.CreateAtask
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components.NewTaskContent
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components.NewTaskTopBar

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewTaskScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            NewTaskTopBar()
        },
        content = {
            NewTaskContent()
        },
        bottomBar = {
        }
    )
    CreateAtask(navController)
}
