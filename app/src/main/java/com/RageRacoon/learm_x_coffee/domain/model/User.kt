package com.RageRacoon.learm_x_coffee.domain.model

data class User (
    var id: String = "",
    var userName: String = "",
    var correo: String = "",
    var password: String = "",
    var passwordConfirm: String = ""
)