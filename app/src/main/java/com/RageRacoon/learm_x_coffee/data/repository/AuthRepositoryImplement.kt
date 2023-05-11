package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImplement @Inject constructor(private val firebaseAuth: FirebaseAuth): AuthRepository { //Extiende de AuthRepository, que esta en la capade dominio, ya que se quiere implemntar la  interfaz

    override val sesionUser: FirebaseUser? get() = firebaseAuth.currentUser //Retorna usuario de sesion siempre que exista

    override suspend fun login(email: String, password: String): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email,password).await()
            Response.Successful(result.user!!) //da igual que de erro o null, ya que tratamos la excepcion
        }catch (e:Exception){
            Response.Failure(e)
        }
    }

    override fun loginOut() {
        firebaseAuth.signOut()
    }

    override suspend fun register(user: User): Response<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(user.correo,user.password).await()
            Response.Successful(result.user!!)
        }catch (e:Exception) {
            Response.Failure(e)
        }
    }
}