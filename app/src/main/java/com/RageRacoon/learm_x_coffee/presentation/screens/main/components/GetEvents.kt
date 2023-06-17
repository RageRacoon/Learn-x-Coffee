package com.RageRacoon.learm_x_coffee.presentation.screens.main.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.MainContent
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles

@Composable
fun GetEvents (viewModel:MainViewModel = hiltViewModel()){
    var utiles = DateUtiles()
    when(val registerResponse = viewModel.eventsResponse){
        Response.Loading -> {
            MyLoadingProgressBar()
        }
        is Response.Successful -> {
            MainContent(tasks = registerResponse.data)
            LaunchedEffect(Unit){
                viewModel.currentDate= utiles.getWeekday()
                viewModel.date= utiles.getDate()
            }
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, registerResponse.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
        }
        else -> {}
    }

}