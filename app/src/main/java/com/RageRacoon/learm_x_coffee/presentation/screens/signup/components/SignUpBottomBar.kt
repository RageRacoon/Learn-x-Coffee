package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen

@Composable
fun SignUpBottomBar(navController: NavHostController){
    Divider(
        color = MaterialTheme.colors.primary,
        thickness = 1.dp,
        modifier = Modifier.fillMaxWidth()
    )
    Row (
        modifier = Modifier
            .padding(bottom = 15.dp, top = 15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "¿Ya tiene una cuenta?",
            fontSize = 18.sp,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .wrapContentSize(),
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            modifier = Modifier.clickable{
                navController.navigate(route = AppScreen.LogInScreen.rutaPantalla)
            },
            text = "Inicie Sesión",
            fontSize = 18.sp,
            color = MaterialTheme.colors.primary
        )
    }


}