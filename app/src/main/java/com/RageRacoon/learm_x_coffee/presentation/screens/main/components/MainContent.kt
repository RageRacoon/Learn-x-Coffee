package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel


@Composable
fun MainContent(navController: NavHostController,viewModel: MainViewModel = hiltViewModel()){
    Column() {
        MyButton(
            modifier = Modifier,
            text = "LoginOut",
            onClick = {
                viewModel.logOut()
                navController.navigate(route = AppScreen.LogInScreen.rutaPantalla){
                    popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true}
                }
            })
        MyButton(
            modifier = Modifier,
            text = "Perfil",
            onClick = {
                navController.navigate(route = AppScreen.ProfileScreen.rutaPantalla){
                    popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true}
                }
            })

    }
}