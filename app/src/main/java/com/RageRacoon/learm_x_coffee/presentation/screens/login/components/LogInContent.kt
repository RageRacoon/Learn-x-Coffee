package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
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
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen


@Composable
fun LogInContent (navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){
    val state = viewModel.state
     Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp),
            text = "Log In"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Inicie sesión en la app"
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.email, //Clase manejadora de estados.
            onValueChange = { viewModel.emailInput(it) }, //Actualiza el valor de la constante de la calse State
            label = "Correo electrónico",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailErrMsg,
            validateField = {}
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.password,
            onValueChange = { viewModel.passwordInput(it) },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            hideText = true,
            errorMsg = viewModel.passwordErrMsg,
            validateField = { }
        )
        Button(
            modifier = Modifier.clickable(enabled = viewModel.isClickableLoginButton) {  },
            onClick = {
            viewModel.login()

        },) {
            Text(text = "Iniciar sesión")
        }

    }

}