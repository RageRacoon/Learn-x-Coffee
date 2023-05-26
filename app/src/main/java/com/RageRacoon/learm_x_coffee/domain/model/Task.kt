package com.RageRacoon.learm_x_coffee.domain.model

open class Task(
    val idTask : String = "",
    val eventCreator: String = "",
    val otherParticipants: List<String> = mutableListOf(""),
    val finished: Boolean = false,
    val nameEvent: String = "",
    val dayTask :String =" ",
    val monthTask :String =" ",
    val yearTask :String =" ",
    val periodsOfTheDay: String = "",
    val iconTask: String= "",
) {}
