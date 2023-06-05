package com.RageRacoon.learm_x_coffee

import android.media.midi.MidiOutputPort
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController:NavHostController) {
    LaunchedEffect(key1 = true){
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreen.LogInScreen.rutaPantalla)
    }


    Splash()
}

@Composable
fun Splash(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_learn_x_coffee),
            contentDescription = "Logo de la empresa",
            Modifier.size(313.dp)
        )
        Text("Learn x coffee",
            fontSize = 45.sp,
            color = MaterialTheme.colors.primary
        )

    }
}