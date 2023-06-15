package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen


@Composable
fun Login (navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){
    when(val loginResponse = viewModel.loginResponse){
        //Si el estado de la respuesta es loggin, muestra una progresbar
            Response.Loading -> { //Mientras que las respuesta sea Loading, que se muestre la progres bar
                MyLoadingProgressBar()
            }
            is Response.Successful -> {
                //Si sa se ha registrado una vez, te envia directamente a la main screen
                LaunchedEffect(Unit){
                    navController.navigate(AppScreen.MainScreen.rutaPantalla){
                        popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true} //Se elimina el historial de pantalla
                    }
                }
                Toast.makeText(LocalContext.current, "Inicio de sesion correcto", Toast.LENGTH_SHORT).show()

            }
            is Response.Failure -> {
                Toast.makeText(LocalContext.current, loginResponse.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
            }
            else -> {
            }
        }
}