package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.utiles.Constantes
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Named

interface UsersRepository{
    suspend fun createNewUser(user: User): Response<Boolean> //Boleano que confirma si el nuevo usuario se a almacenado o no

    suspend fun edit(user:User): Response<Boolean>
    suspend fun saveImg(file: File): Response<String> //Metodo que recibira un file (la img) y la almacenara en base de datos
    fun getUser(id:String): Flow<User>
}