package com.RageRacoon.learm_x_coffee.presentation.screens.calendar

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.calendar.components.CalendarBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.calendar.components.GetEventsOfTheCalendar
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.MainBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.MainTopBar
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.GetEvents

@RequiresApi(Build.VERSION_CODES.N)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CalendarScreen(navController : NavHostController) {
    Scaffold(
        topBar = {
            MainTopBar(navController)
        },
        content = {
            GetEventsOfTheCalendar()
        },
        bottomBar = {
            CalendarBottomBar(navController)
        }
    )
}