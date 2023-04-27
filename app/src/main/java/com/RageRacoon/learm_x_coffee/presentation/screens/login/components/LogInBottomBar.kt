package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen


@Composable
fun LoginBottomBar(navController: NavHostController){
    Row (
        modifier = Modifier
            .padding(bottom = 50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        MyText(nivel = 2, texto = "Unete a Learn x Coffee")
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier.clickable{
                navController.navigate(route = AppScreen.SignUpScreen.rutaPantalla)
            },
            text = "RESGISTRATE YA!!",
            fontSize = 18.sp,
            color = MaterialTheme.colors.primary
        )
    }


}