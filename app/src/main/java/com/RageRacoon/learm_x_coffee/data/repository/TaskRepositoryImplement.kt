package com.RageRacoon.learm_x_coffee.data.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.repository.TaskRepository
import com.RageRacoon.learm_x_coffee.utiles.Constantes
import com.RageRacoon.learm_x_coffee.utiles.Constantes.TASK_COLLECTION_NAME
import com.google.android.gms.tasks.Tasks
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
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

    override fun getTask(userid: String): Flow<Response<List<Task>>> = callbackFlow{
        val listener = taskCollection.whereEqualTo("eventCreator", userid)
            .addSnapshotListener{ snapshot, e ->
            val tasksResponse = if (snapshot != null){
                val tasks = snapshot.toObjects(Task::class.java)
                Response.Successful(tasks)
            }
            else {
                Response.Failure(e)
            }
            trySend(tasksResponse)
        }
        awaitClose(){
            listener.remove()
        }


    }

    override suspend fun updateTask(task: Task): Response<Boolean> {
        return try {
            val map: MutableMap<String, Any> = HashMap()
            map["streak"] = task.streak
            map["done"] = task.done
            map["finished"] = task.finished
            taskCollection.document(task.idTask).update(map).await()
            Response.Successful(true)
        }catch (e: Exception){
            Response.Failure(e)
        }
    }
}