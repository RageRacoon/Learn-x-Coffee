package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.domain.repository.TaskRepository
import com.RageRacoon.learm_x_coffee.utiles.Constantes
import com.RageRacoon.learm_x_coffee.utiles.Constantes.TASK_COLLECTION_NAME
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Named

class TaskRepositoryImplement @Inject constructor(
    @Named(TASK_COLLECTION_NAME) private val taskCollection: CollectionReference): TaskRepository {
    override suspend fun createNewTask(task: Task): Response<Boolean> {
        return try {
            taskCollection.add(task).await()
            Response.Successful(true)
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }

}