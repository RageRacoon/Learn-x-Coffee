package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun SinUpContent (navHostController: NavHostController, viewModel: SingUpViewModel = hiltViewModel()){

    val state = viewModel.state //States, de esta screen
    val contexto = LocalContext.current

   Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField(
            modifier = Modifier.padding(top = 15.dp),
            texto =  state.username,
            onValueChange = { viewModel.userNameImput(it) },
            label = "Nombre de usuario",
            icon = Icons.Default.Person,
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto =  state.email,
            onValueChange = { viewModel.emailInput(it) },
            label = "Correo electronico",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailError
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto =  state.password,
            onValueChange = { viewModel.passwordInput(it) },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            hideText = true,
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.confirmPasword,
            onValueChange = { viewModel.confirmPasswordInput(it) },
            label = "Confirmar Contraseña",
            icon = Icons.Outlined.Lock,
            hideText = true,
            errorMsg = viewModel.confirmPasswordError,
            validateField = { viewModel.validateConfirmPassword() }
        )
        Button(onClick = {
            viewModel.onRegister()
        }) {
            Text(text = "Registrarse")
        }
    }

}