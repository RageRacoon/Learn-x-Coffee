package com.RageRacoon.learm_x_coffee.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.graphics.vector.ImageVector

open class Task(
    val idTask : String = "",
    val eventCreator: String = "",
    val otherParticipants: List<String> = mutableListOf(""),
    var finished: Boolean = false,
    val nameEvent: String = "",
    val dayTask :String =" ",
    val monthTask :String =" ",
    val yearTask :String =" ",
    val periodsOfTheDay: String = "",
    var streak: Int= 0,
    val dateOfTheHabits: List<String> = mutableListOf(""),
    var done: Boolean = false,
    val itIsAHabit: Boolean = true,
)
