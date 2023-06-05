package com.RageRacoon.learm_x_coffee.domain.use_cases.users

import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import javax.inject.Inject

class Create @Inject constructor(private val repository: UsersRepository){ //Crear un usuario e n la base de datos de firestore Database
suspend operator fun invoke(use:User) = repository.createNewUser(use)
}