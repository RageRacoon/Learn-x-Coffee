package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class AuthRepositoryImplement: AuthRepository {
    val firebaseAuth = FirebaseAuth.getInstance()

    override val sesionUser: FirebaseUser? get() = firebaseAuth.currentUser //Retorna usuario de sesion siempre que exista


    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email,password).await()
            Response.Successful(result.user!!) //da igual que de erro o null, ya que tratamos la excepcion
        }catch (e:Exception){
            Response.Failure(e)
        }
    }
}