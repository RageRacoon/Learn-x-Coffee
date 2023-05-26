package com.RageRacoon.learm_x_coffee.domain.model

open class Event(
    var eventCreator: String = "",
    var finished: Boolean = false,
    var nameEvent: String = "",
) {}
