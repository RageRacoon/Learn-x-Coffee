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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LogInContent
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginTopBar

@Composable
fun LogInScreen(navController : NavHostController) {
   Scaffold(
       topBar = {
           LoginTopBar()
       },
       content = {
           LogInContent (it)
       },
       bottomBar = {
           LoginBottomBar(navController)
       }
   )

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LogInScreenPrePreview(){
    LogInScreen(rememberNavController())
}