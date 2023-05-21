package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository{
    suspend fun createNewUser(user: User): Response<Boolean> //Boleano que confirma si el nuevo usuario se a almacenado o no

    suspend fun edit(user:User): Response<Boolean>
    fun getUser(id:String): Flow<User>

}