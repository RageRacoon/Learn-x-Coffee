package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField


@Composable
fun SinUpContent (paddingValues: PaddingValues){
    var texto by remember { mutableStateOf(TextFieldValue("")) }
   /* Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
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
            texto = state.username,
            onValueChange = { viewModel.onUsernameInput(it) },
            label = "Nombre de usuario",
            icon = Icons.Default.Person,
            errorMsg = viewModel.usernameErrMsg,
            validateField = { viewModel.validateUsername() }
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
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = state.confirmPassword,
            onValueChange = { viewModel.onConfirmPasswordInput(it) },
            label = "Confirmar Contraseña",
            icon = Icons.Outlined.Lock,
            hideText = true,
            errorMsg = viewModel.confirmPasswordErrMsg,
            validateField = { viewModel.validateConfirmPassword() }
        )
        Button(onClick = { /*Evento que se dispara al accer click*/ }) {
            Text(text = "Registrarse")
        }
    }
*/
}