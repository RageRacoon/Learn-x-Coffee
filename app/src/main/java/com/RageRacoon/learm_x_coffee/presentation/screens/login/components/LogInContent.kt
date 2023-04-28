package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.widget.VideoView
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
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginState
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel


@Composable
fun LogInContent (paddingValues: PaddingValues,
                  viewModel: LoginViewModel,
                  state: LoginState){
 var texto by remember { mutableStateOf(TextFieldValue("")) }
     Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
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
            validateField = { viewModel.validateEmail() }
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.password,
            onValueChange = { viewModel.onPasswordInput(it) },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            hideText = true,
            errorMsg = viewModel.passwordErrMsg,
            validateField = { viewModel.validatePassword() }
        )
        Button(onClick = { /*Evento que se dispara al accer click*/ }) {
            Text(text = "Registrarse")
        }
    }
}