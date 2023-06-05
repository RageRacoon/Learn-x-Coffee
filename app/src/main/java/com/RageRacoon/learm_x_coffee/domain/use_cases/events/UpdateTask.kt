package com.RageRacoon.learm_x_coffee.domain.use_cases.events

import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.domain.repository.TaskRepository
import java.text.FieldPosition
import javax.inject.Inject


class UpdateTask @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(task: Task) = repository.updateTask(task)
}