package com.RageRacoon.learm_x_coffee

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LogInContent

@Composable
fun LogInScreen() {
   Scaffold(
       topBar = {},
       content = {
           LogInContent(it)
       },
       bottomBar = {}
   )

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LogInScreenPrePreview(){
    LogInScreen()
}