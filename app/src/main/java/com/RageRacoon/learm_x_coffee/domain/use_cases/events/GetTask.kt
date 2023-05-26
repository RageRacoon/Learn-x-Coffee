package com.RageRacoon.learm_x_coffee.domain.use_cases.events

import com.RageRacoon.learm_x_coffee.domain.repository.TaskRepository
import javax.inject.Inject

class GetTask @Inject constructor(private val repository: TaskRepository){
    operator fun invoke(userid: String) = repository.getTask(userid)
}