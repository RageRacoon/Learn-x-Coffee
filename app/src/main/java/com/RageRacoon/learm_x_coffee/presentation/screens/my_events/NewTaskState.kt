package com.RageRacoon.learm_x_coffee.presentation.screens.my_events

import androidx.compose.runtime.remember
import java.time.LocalDate
import java.util.Date

data class NewTaskState(
    val taskName :String =" ",
    val dayTask :String =" ",
    val monthTask :String =" ",
    val yearTask :String =" ",
)
