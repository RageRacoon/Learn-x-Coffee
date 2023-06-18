package com.RageRacoon.learm_x_coffee.presentation.screens.calendar

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
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainScreenState
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(private val eventsUsecase: EventsUsecase): ViewModel() {

        var state by mutableStateOf(MainScreenState())
            private set
        var editTaskResponse by mutableStateOf<Response<Boolean>?>(null)
            private set
    //Dias
        var currentDate by mutableStateOf<String>(" ")
        var date by mutableStateOf<String>(" ")
        var intDiasAdelantados by mutableStateOf<Int>(1)


        ////Eventos
        var eventsResponse by mutableStateOf<Response<List<Task>>?>(null)

}