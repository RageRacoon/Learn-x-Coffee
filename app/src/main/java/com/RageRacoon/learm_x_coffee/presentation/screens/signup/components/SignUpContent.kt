package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.presentation.components.MyLoadingProgressBar


@Composable
fun SinUpContent (navHostController: NavHostController, viewModel: SingUpViewModel = hiltViewModel()){

    val state = viewModel.state //States, de esta screen

   Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(255.dp),
            painter = painterResource(id = R.drawable.sprite_racoon),
            contentDescription = "Img perfil")
        MyTextField(
            modifier = Modifier.padding(top = 25.dp),
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
    //Evaluamos el esatado del registro


}