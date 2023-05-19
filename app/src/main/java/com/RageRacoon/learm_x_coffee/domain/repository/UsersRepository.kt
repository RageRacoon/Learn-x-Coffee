package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User

interface UsersRepository{
    suspend fun createNewUser(user: User): Response<Boolean> //Boleano que confirma si el nuevo usuario se a almacenado o no

}