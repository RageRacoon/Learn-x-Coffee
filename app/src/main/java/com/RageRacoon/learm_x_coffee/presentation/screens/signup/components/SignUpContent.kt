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


@Composable
fun SinUpContent (navHostController: NavHostController, viewModel: SingUpViewModel = hiltViewModel()){

    val registerFlow = viewModel.registerFlow.collectAsState()

    var texto by remember { mutableStateOf(TextFieldValue("")) }
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
            texto =  viewModel.username.value,
            onValueChange = { viewModel.username.value = it },
            label = "Nombre de usuario",
            icon = Icons.Default.Person,
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto =  viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            label = "Correo electronico",
            icon = Icons.Default.Email,
            keyboardType = KeyboardType.Email,
            errorMsg = viewModel.emailError.value
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto =  viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            label = "Contraseña",
            icon = Icons.Default.Lock,
            hideText = true,
        )
        MyTextField(
            modifier = Modifier.padding(top = 0.dp),
            texto = viewModel.confirmPassword.value,
            onValueChange = { viewModel.confirmPassword.value = it },
            label = "Confirmar Contraseña",
            icon = Icons.Outlined.Lock,
            hideText = true,
            errorMsg = viewModel.confirmPasswordError.value,
            validateField = { viewModel.validateConfirmPassword() }
        )
        Button(onClick = {
            viewModel.onRegister()
        }) {
            Text(text = "Registrarse")
        }
    }
    //Evaluamos el esatado del registro

    registerFlow.value.let {
        when(it){
            Response.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    CircularProgressIndicator()
                }
            }
            is Response.Successful -> {
                LaunchedEffect(Unit){
                    viewModel.createNewUser() // Asi solo se crea el nuevo usuario si la peticion a la base de datros ha sido exitosa
                    navHostController.popBackStack(AppScreen.LogInScreen.rutaPantalla, inclusive = true)
                    navHostController.navigate(route = AppScreen.ProfileScreen.rutaPantalla)
                }
            }
            is Response.Failure -> {
                Toast.makeText(LocalContext.current, it.exception?.message ?: "Error critico", Toast.LENGTH_LONG).show()
            }
            else -> {}
        }
    }
}