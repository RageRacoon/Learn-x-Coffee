package com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components

import android.util.Log
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
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel

@Composable
fun CreateAtask (navController: NavHostController, viewModel: NewTaskViewModel = hiltViewModel()){
        when(val registerResponse = viewModel.createTaskResponse){
            Response.Loading -> {
                MyLoadingProgressBar()
            }
            is Response.Successful -> {
                viewModel.cleanForm()
            }

            is Response.Failure -> {
                Toast.makeText(LocalContext.current, registerResponse.exception?.message ?: "Error critico", Toast.LENGTH_SHORT).show()
            }
            else -> {}
        }
}