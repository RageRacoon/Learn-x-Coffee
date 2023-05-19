package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.UsersRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UsersRepositoryImplements @Inject constructor(private val usersCollection: CollectionReference): UsersRepository {

    override suspend fun createNewUser(user: User): Response<Boolean> {
        return try {
            usersCollection.document(user.id).set(user).await()
            Response.Successful(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}