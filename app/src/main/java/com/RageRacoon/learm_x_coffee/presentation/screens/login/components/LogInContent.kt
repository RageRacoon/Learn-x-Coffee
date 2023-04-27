package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyText


@Composable
fun LogInContent (paddingValues: PaddingValues){
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
        TextField(
            modifier = Modifier
                .padding(top = 15.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Nombre de usuario")
            }

        )
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = texto,
            onValueChange = { texto = it},
            placeholder = {
                Text(text = "Contrasena")
            }

        )
        Button(onClick = { /*Evento que se dispara al accer click*/ }) {
            Text(text = "Log in")
        }
    }

}

