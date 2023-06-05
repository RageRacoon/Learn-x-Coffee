package com.RageRacoon.learm_x_coffee.presentation.screens.my_events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.domain.model.User
import com.RageRacoon.learm_x_coffee.domain.use_cases.events.EventsUsecase
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class NewTaskViewModel @Inject constructor(
    private val eventsUsecase: EventsUsecase,
    private val loginUseCase: LoginUseCase): ViewModel() {

    var state by mutableStateOf(NewTaskState())
    val userInfo = loginUseCase.getUser()
    var createTaskResponse by mutableStateOf<Response<Boolean>?>(null)
    private set

    fun taskNameImput(taskName: String){
        state = state.copy(taskName = taskName)
    }
    fun createTask() = viewModelScope.launch {
        createTaskResponse= Response.Loading
        val task = Task(
            nameEvent = state.taskName,
            eventCreator = userInfo!!.uid,
        )
        val result = eventsUsecase.createTask(task)
        createTaskResponse = result
    }

    fun cleanForm(){
        state = state.copy(
            yearTask = "",
            monthTask = "",
            dayTask = "",
            taskName = ""
        )
        createTaskResponse=null
    }

    fun dayTaskImput(dayTask: String){
        state = state.copy(dayTask = dayTask)
    }




}