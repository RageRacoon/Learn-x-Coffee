package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository { //Solo definimos metodos y variables
    val sesionUser: FirebaseUser?
    suspend fun login(email:String, password: String): Response<FirebaseUser> // al hacer login, retorna el objeto usuario
}