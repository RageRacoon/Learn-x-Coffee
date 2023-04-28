package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository

class Login {
    val repository: AuthRepository = AuthRepositoryImplement()
    //Se lanza la funcin cuando se llama a la clase
    suspend operator fun invoke (email: String, password: String) = repository.login(email,password)

}