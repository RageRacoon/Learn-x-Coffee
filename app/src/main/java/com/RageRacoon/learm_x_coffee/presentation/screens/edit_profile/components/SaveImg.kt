package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.EditProfileViewModel

@Composable
fun SaveImg (viewModel: EditProfileViewModel = hiltViewModel()){
    //Evaluar estados en los que se encunetra la respuesta
    when(val responseSaveImg = viewModel.uploadImg){
        Response.Loading -> { //Mientras que las respuesta sea Loading, que se muestre la progres bar
            MyLoadingProgressBar()
        }
        is Response.Successful -> {
            viewModel.clickEdit(responseSaveImg.data)
            Toast.makeText(LocalContext.current, "Datos editados", Toast.LENGTH_LONG).show()
        }
        is Response.Failure -> {
            Toast.makeText(LocalContext.current, responseSaveImg.exception?.message ?: "Error al editar el perfil", Toast.LENGTH_LONG).show()
        }
        else -> {
        }
    }
}