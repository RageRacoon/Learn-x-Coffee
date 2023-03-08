package com.RageRacoon.learm_x_coffee

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.checkerframework.common.subtyping.qual.Bottom

@Composable
fun LogInScreen(){
    LogInForm()
}

@Composable
fun LogInForm(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            modifier = Modifier
                .height(130.dp),
            painter = painterResource(id = R.drawable.logo_learn_x_coffee_1204),
            contentDescription = "Logotipo de la app")

        Text(
            text = "Welcome to Lear x Coffee"
        )
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
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "Contrasena")
            }

        )
        Button(onClick = { /*Evento que se dispara al accer click*/ }) {
            Text(text = "Log in")
        }
    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LogInScreenPrePreview(){
    LogInForm()
}