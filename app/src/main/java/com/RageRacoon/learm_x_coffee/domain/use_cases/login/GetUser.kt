package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import javax.inject.Inject

class GetUser @Inject constructor(private val repository: AuthRepository) {

        //Se lanza la funcin cuando se llama a la clase
        operator fun invoke () = repository.sesionUser
}