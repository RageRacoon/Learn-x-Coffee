package com.RageRacoon.learm_x_coffee.presentation.screens.main

import androidx.compose.runtime.currentComposer
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
import com.RageRacoon.learm_x_coffee.domain.use_cases.users.ProfilesUseCase
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskState
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val eventsUsecase: EventsUsecase,
    private val profilesUseCase: ProfilesUseCase):ViewModel() {

    var state by mutableStateOf(MainScreenState())
        private set
    var userInfo by mutableStateOf(User())
        private set
    val activeUser = loginUseCase.getUser()
    var editTaskResponse by mutableStateOf<Response<Boolean>?>(null)
        private set
    init{ //Init es el primer métoado que se lanza al estnaciar el viewModel
        getUserById()
    }

    fun logOut(){
        loginUseCase.loginOut()
    }
    private fun getUserById() = viewModelScope.launch {
        profilesUseCase.getUserById(activeUser!!.uid).collect(){
            userInfo = it
        } //Se le suministra la Id, del usaurio activo en ese momento
    }

    ////Eventos
    var tooday by mutableStateOf("")
    var eventsResponse by mutableStateOf<Response<List<Task>>?>(null)

    init {
        getTask()
        var utils = DateUtiles()
        tooday = utils.getDate()
    }
    fun getTask() = viewModelScope.launch {
        eventsResponse = Response.Loading
        eventsUsecase.getTask(activeUser!!.uid).collect(){
            response -> eventsResponse = response
        }

    }

    fun getHabit() = viewModelScope.launch {
        eventsResponse = Response.Loading
        eventsUsecase.getTask(activeUser!!.uid).collect(){
                response -> eventsResponse = response
        }

    }

    fun updateTask(task: Task) = viewModelScope.launch {
        editTaskResponse= Response.Loading
        val result = eventsUsecase.updateTask(task)
        editTaskResponse = result
    }

    fun onUpdateTask(task: Task){
        updateTask(task)
    }

}