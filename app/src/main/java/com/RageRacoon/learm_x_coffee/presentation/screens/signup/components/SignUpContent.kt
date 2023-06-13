package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
fun SinUpContent (navHostController: NavHostController, viewModel: SingUpViewModel = hiltViewModel()){

    val state = viewModel.state //States, de esta screen


   Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Spacer(modifier = Modifier.height(15.dp))
       OutlinedTextField(
           value = state.username,
           onValueChange = {
               viewModel.userNameImput(it)
               viewModel.isUsernameOk = false
           },
           isError = viewModel.isUsernameOk,
           label = { Text("Nombre de usuario") },
           interactionSource = remember { MutableInteractionSource() },
           leadingIcon = {
               if(viewModel.isUsernameOk == true){
                   Icon(
                       Icons.Filled.Person,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.onError
                   )
               }else{
                   Icon(
                       Icons.Filled.Person,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.primary
                   )
               }
           }
       )
       if (viewModel.isUsernameOk == true) {
           Text(
               text = "* El nombre de usuario no puede estar vacío.",
               color = MaterialTheme.colors.onError,
               style = TextStyle(fontSize = 12.sp),
               modifier = Modifier,
               textAlign = TextAlign.Center
           )
       }

       Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = state.email,
            onValueChange = {
                viewModel.emailInput(it)
                viewModel.isEmailOk = false
            },
            isError = viewModel.isEmailOk,
            label = { Text("Correo Electrónico") },
            interactionSource = remember { MutableInteractionSource() },
            leadingIcon = {
                if(viewModel.isEmailOk == true){
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "Icono izquierdo",
                        tint = MaterialTheme.colors.onError
                    )
                }else{
                    Icon(
                            Icons.Filled.Email,
                        contentDescription = "Icono izquierdo",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        )
       if (viewModel.isEmailOk == true) {
           Text(
               text = "* El formato del correo electrónico no es correcto.",
               color = MaterialTheme.colors.onError,
               style = TextStyle(fontSize = 12.sp),
               modifier = Modifier,
               textAlign = TextAlign.Center
           )
       }
       Spacer(modifier = Modifier.height(12.dp))
       OutlinedTextField(
           value = state.password,
           onValueChange = {
               viewModel.passwordInput(it)
               viewModel.isPasswordOk = false
           },
           isError = viewModel.isPasswordOk,
           label = { Text("Correo Electrónico") },
           interactionSource = remember { MutableInteractionSource() },
           visualTransformation = PasswordVisualTransformation(),
           leadingIcon = {
               if(viewModel.isPasswordOk == true){
                   Icon(
                       Icons.Filled.Lock,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.onError
                   )
               }else{
                   Icon(
                           Icons.Filled.Lock,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.primary
                   )
               }
           }
       )
       if (viewModel.isPasswordOk == true) {
           Text(
               text = "* La contraseña debe ser de 6 caracteres como mínimo.",
               color = MaterialTheme.colors.onError,
               style = TextStyle(fontSize = 12.sp),
               modifier = Modifier,
               textAlign = TextAlign.Center
           )
       }
       Spacer(modifier = Modifier.height(12.dp))
       OutlinedTextField(
           value = state.confirmPasword,
           onValueChange = {
               viewModel.confirmPasswordInput(it)
               viewModel.isConfirmPasswordOk = false
           },
           isError = viewModel.isConfirmPasswordOk,
           label = { Text("Correo Electrónico") },
           interactionSource = remember { MutableInteractionSource() },
           visualTransformation = PasswordVisualTransformation(),
           leadingIcon = {
               if(viewModel.isConfirmPasswordOk == true){
                   Icon(
                       Icons.Outlined.Lock,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.onError
                   )
               }else{
                   Icon(
                       Icons.Outlined.Lock,
                       contentDescription = "Icono izquierdo",
                       tint = MaterialTheme.colors.primary
                   )
               }
           }
       )
       if (viewModel.isConfirmPasswordOk == true) {
           Text(
               text = "* Las contraseñas deben coincidir.",
               color = MaterialTheme.colors.onError,
               style = TextStyle(fontSize = 12.sp),
               modifier = Modifier,
               textAlign = TextAlign.Center
           )
       }

       Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {
            if(viewModel.usernameNotVoid() == false){
                viewModel.isUsernameOk = true
            }
            if(viewModel.formatEmail() == false){
                viewModel.isEmailOk = true
            }
            if(viewModel.minCaracteres() == false){
                viewModel.isPasswordOk = true
            }
            if(viewModel.validateConfirmPassword() == false){
                viewModel.isConfirmPasswordOk = true
            }
            if(viewModel.minCaracteres() == true && viewModel.formatEmail() == true && viewModel.validateConfirmPassword() == true && viewModel.usernameNotVoid() == true){
                viewModel.onRegister()
            }
        })
        {
            Text(text = "Registrarse")
        }
    }
}