package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.EditProfileViewModel

@Composable
fun Edit (viewModel: EditProfileViewModel = hiltViewModel()){
    //Evaluar estados en los que se encunetra la respuesta
    when(val responseEdit = viewModel.editResponse){
        Response.Loading -> { //Mientras que las respuesta sea Loading, que se muestre la progres bar
            MyLoadingProgressBar()
        }
        is Response.Successful -> {

            Toast.makeText(LocalContext.current, "Datos editados", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, responseEdit.exception?.message ?: "Error al editar el perfil", Toast.LENGTH_LONG).show()
        }
        else -> {
        }
    }
}