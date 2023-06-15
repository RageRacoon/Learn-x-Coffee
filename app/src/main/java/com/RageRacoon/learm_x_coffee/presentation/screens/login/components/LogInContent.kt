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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen


@Composable
fun LogInContent (navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()){
    val state = viewModel.state
     Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Inicie sesión en la app",
            fontSize = 14.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize()
                .padding(horizontal = 35.dp), textAlign = TextAlign.Center, fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(55.dp))
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.email, //Clase manejadora de estados.
            onValueChange = { viewModel.emailInput(it) }, //Actualiza el valor de la constante de la clase State
            label = "Correo electrónico",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailErrMsg,
            validateField = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
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
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            modifier = Modifier.clickable(enabled = viewModel.isClickableLoginButton) {  },
            onClick = {
            viewModel.login()

        },) {
            Text(text = "Iniciar sesión")
        }

    }

}