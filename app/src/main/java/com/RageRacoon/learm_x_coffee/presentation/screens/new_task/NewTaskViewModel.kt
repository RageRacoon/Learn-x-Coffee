package com.RageRacoon.learm_x_coffee.presentation.screens.new_task

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.domain.use_cases.events.EventsUsecase
import com.RageRacoon.learm_x_coffee.domain.use_cases.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
        state = state.copy(nameEvent = taskName)
    }
    fun createTask() = viewModelScope.launch {
        createTaskResponse= Response.Loading
        val task = Task(
            nameEvent = state.nameEvent,
            eventCreator = userInfo!!.uid,
            dateOfTheHabits = state.dateOfTheHabits.toList(),
            itIsAHabit = state.itIsAHabit,
            intOfArrayOfIcons = state.intOfArrayOfIcons
        )
        val result = eventsUsecase.createTask(task)
        createTaskResponse = result
    }

    fun cleanForm(){
        state = state.copy(
            yearTask = "",
            monthTask = "",
            dayTask = "",
            nameEvent = ""
        )
        createTaskResponse=null
    }

    fun dayTaskImput(dayTask: String){
        state = state.copy(dayTask = dayTask)
    }

    fun isAHabit(response: Boolean){
        state = state.copy(itIsAHabit = response)
    }

    fun addDay(diasSeleccionados: Set<String>){
        state = state.copy(dateOfTheHabits = diasSeleccionados)
        Log.d("TAG", "Contenido del arreglo: ${state.dateOfTheHabits.joinToString()}")
    }
    fun isTheNameEmpty():Boolean{
        var resul = false
        return false
    }

    fun setIconOfTheList(position:Int){
        state = state.copy(intOfArrayOfIcons = position)
    }

}