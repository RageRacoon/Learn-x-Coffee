package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.components.MyRoundImage
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen


@Composable
fun ProfileContent(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(192.dp),
                painter = painterResource(id = R.drawable.banner_perfil01),
                contentDescription = "Banner imagen",
                contentScale = ContentScale.Crop,
                alpha = 0.75F
                )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            MyRoundImage(R.drawable.sprite_racoon)
            MyText(nivel = 1, texto = "Nombre Usuario")
        }
        }
        MyText(nivel = 1, texto = "correo asociado al usuario")
    }
}

@Preview(showBackground = true)
@Composable
fun PerfilContentPreview(){
}