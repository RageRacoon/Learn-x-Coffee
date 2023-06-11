package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.components.MyTopBar

@Composable
fun SignUpTopBar(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            modifier = Modifier
                .height(225.dp),
            painter = painterResource(id = R.drawable.logo_learn_x_coffee_1204),
            contentDescription = "Logotipo de la app")
        Text(
            fontSize = 20.sp,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(top = 0.dp),
            text = "Sign Up"
        )
        Spacer(modifier = Modifier.height(2.dp))
        MyText(
            nivel = 3,
            texto = "Regístrese en la app"
        )
    }

}