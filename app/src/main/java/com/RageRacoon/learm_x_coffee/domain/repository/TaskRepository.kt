package com.RageRacoon.learm_x_coffee.domain.repository

import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun createNewTask(task: Task):Response<Boolean>
    fun getTask(Userid: String): Flow<Response<List<Task>>>

    suspend fun updateTask(task: Task):Response<Boolean>
}