package com.RageRacoon.learm_x_coffee.domain.use_cases.login

import com.RageRacoon.learm_x_coffee.data.repository.AuthRepositoryImplement
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(private val repository: AuthRepository) {
    //Se lanza la funcin cuando se llama a la clase
    suspend operator fun invoke (email: String, password: String) = repository.login(email,password) //invoke permite al llamar una clase, lanzar dicha funcion, co rutinas

}