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
    val loginFlow = viewModel.loginFlow.collectAsState()
     Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp),
            text = "Log in"
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Inicie sesion en la app"
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.email,
            onValueChange = { viewModel.onEmailInput(it) },
            label = "Correo electronico",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailErrMsg,
            validateField = {}
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.password,
            onValueChange = { viewModel.onPasswordInput(it) },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            hideText = true,
            errorMsg = viewModel.passwordErrMsg,
            validateField = { }
        )
        Button( onClick = {
            viewModel.login()

        },) {
            Text(text = "Registrarse")
        }

    }
   loginFlow.value.let {
       when(it){
           //Si el estado de la respuesta es loggin, muestra una progresbar
           Response.Loading -> {
               Box(
                   contentAlignment = Alignment.Center,
                   modifier = Modifier.fillMaxSize()
               ){
                   LinearProgressIndicator()
               }
           }
           is Response.Successful -> {
               //Si sa se ha registrado una vez, te envia directamente a la main screen
               LaunchedEffect(Unit){
                   navController.navigate(AppScreen.MainScreen.rutaPantalla){
                       popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true} //Se elimina el historial de pantalla
                   }
               }
               Toast.makeText(LocalContext.current, "Inicio de sesion correcto", Toast.LENGTH_LONG).show()

           }
           is Response.Failure -> {
               Toast.makeText(LocalContext.current, it.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
           }
           else -> {
           }
       }

   }
}