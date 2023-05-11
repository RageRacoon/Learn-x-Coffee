package com.RageRacoon.learm_x_coffee.domain.model

data class User (
    val userName: String = "",
    val correo: String = "",
    val password: String = "",
    val passwordConfirm: String = ""
)