package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository

class GetUser {
        val repository: AuthRepository = AuthRepositoryImplement()
        //Se lanza la funcin cuando se llama a la clase
        operator fun invoke () = repository.sesionUser
}