package com.RageRacoon.learm_x_coffee

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LogInScreen(){
    Column {
        Text(text = "Hola puta")
        LogInForm()
    }
}

@Composable
fun LogInForm(){
    Text(text = "Hola")

}

@Preview
@Composable
fun LogInScreenPrePreview(){
    LogInScreen()
}