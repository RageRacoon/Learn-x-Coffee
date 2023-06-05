package com.RageRacoon.learm_x_coffee.domain.model

open class Habit(
    var eventCreator: String = "",
    var finished: Boolean = false,
    var nameEvent: String = "",
    var dates : Array<String>,
    var timesPerDay: String,
    var periodsOfTheDay: String,
) {}

