package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

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
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel

@Composable
fun Register (navController: NavHostController, viewModel: SingUpViewModel = hiltViewModel()){
        when(val registerResponse = viewModel.registerResponse){
            Response.Loading -> {
                MyLoadingProgressBar()
            }
            is Response.Successful -> {
                LaunchedEffect(Unit){
                    viewModel.createNewUser() // Asi solo se crea el nuevo usuario si la peticion a la base de datros ha sido exitosa
                    navController.popBackStack(AppScreen.LogInScreen.rutaPantalla, inclusive = true)
                    navController.navigate(route = AppScreen.ProfileScreen.rutaPantalla)
                }
            }
            is Response.Failure -> {
                Toast.makeText(LocalContext.current, registerResponse.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
}