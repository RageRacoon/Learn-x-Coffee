package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.di.AppModule
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImplements @Inject constructor(private val usersCollection: CollectionReference): UsersRepository {

    override suspend fun createNewUser(user: User): Response<Boolean> {
        user.password = "" //Se busca almacenar una string bgacía para que la pasword solo se alacene en FirebaseAuth
        return try {
            usersCollection.document(user.id).set(user).await()
            Response.Successful(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override suspend fun edit(user: User): Response<Boolean> {
        return try {
            //Para modificar valores en la base de datos, es necesario crear un HashMap, con los valores que vamos a introducir y el campo a editar
            val map: MutableMap<String, Any> = HashMap()
            map["userName"] = user.userName
            map["img"]= user.img
            usersCollection.document(user.id).update(map).await()
            Response.Successful(true)
        } catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    override fun getUser(id: String): Flow<User> = callbackFlow { //Escuchador de la base de datos, ya que se va a modificar en tiempo real, la información que contiene
        val listener = usersCollection.document(id).addSnapshotListener{snapshot,e->
            val user = snapshot?.toObject(User::class.java) ?: User() //En casp de que este método no encuentre la coleccion con el id aportado,(valor null), retornara un User bacio
            trySend(user)
        }
        awaitClose{
            listener.remove() //Borramos el listener cuando se cierra la comuncación, para evitar mas de un listener simultaneo
        }
    }
}