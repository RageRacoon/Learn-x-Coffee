package com.RageRacoon.learm_x_coffee.presentation.screens.new_task

data class NewTaskState(
    val nameEvent: String = "",
    val eventCreator: String = "",
    val otherParticipants: List<String> = mutableListOf(""),
    val dayTask:String =" ",
    val monthTask:String =" ",
    val yearTask:String =" ",
    val periodsOfTheDay: String = "",
    val itIsAHabit: Boolean = true,
    val dateOfTheHabits: Set<String> = setOf(),
    val intOfArrayOfIcons: Int = 0,
)
