package com.RageRacoon.learm_x_coffee.presentation.screens.calendar.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar
import com.RageRacoon.learm_x_coffee.presentation.screens.calendar.CalendarViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.MainContent
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun GetEventsOfTheCalendar (mainviewModel: MainViewModel = hiltViewModel(),
                            calendaViewModel: CalendarViewModel = hiltViewModel()){
    var utiles = DateUtiles()
    when(val registerResponse = mainviewModel.eventsResponse){
        Response.Loading -> {
            MyLoadingProgressBar()
        }
        is Response.Successful -> {
            CalendarContent(tasks = registerResponse.data)
            LaunchedEffect(Unit){
                calendaViewModel.currentDate= utiles.obtenerDiaManana(calendaViewModel.intDiasAdelantados)
                calendaViewModel.date= utiles.getDateMañana(calendaViewModel.intDiasAdelantados)
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, registerResponse.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }

}