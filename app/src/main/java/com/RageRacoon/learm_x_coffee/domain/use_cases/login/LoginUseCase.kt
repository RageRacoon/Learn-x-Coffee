package com.RageRacoon.learm_x_coffee.domain.use_cases.login

data class LoginUseCase( //Aqui se almacenan todos los casos de uso relacionados con el Login y registro
    val login: Login,
    val getUser: GetUser,
    val loginOut: LoginOut,
    val register: Register
)
