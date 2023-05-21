package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository { //Solo definimos metodos y variables
    val sesionUser: FirebaseUser? //Necesario especificar que puede ser null, ya que, puede haber usuasrio evitar el null pointer exception
    suspend fun login(email:String, password: String): Response<FirebaseUser> // al hacer login, retorna el objeto usuario, si retorna null, controlamos el null pointer exception, la respuesta al ser de tipo geneerica, podemos devolver lo que queramos
    fun loginOut()
    suspend fun register(user: User): Response<FirebaseUser>
}

