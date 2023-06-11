package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyText


@Composable
fun LoginTopBar(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            modifier = Modifier
                .height(225.dp),
            painter = painterResource(id = R.drawable.logo_learn_x_coffee_1204),
            contentDescription = "Logotipo de la app")
        Spacer(modifier = Modifier.height(1.dp))
        Text(
            fontSize = 20.sp,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(horizontal = 0.dp),
            text = "Sign In"
        )
    }

}