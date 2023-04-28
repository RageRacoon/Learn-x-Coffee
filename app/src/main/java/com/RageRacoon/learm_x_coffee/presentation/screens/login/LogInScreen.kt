package com.RageRacoon.learm_x_coffee

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginState
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LogInContent
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginBottomBar
import com.RageRacoon.learm_x_coffee.presentation.screens.login.components.LoginTopBar

@Composable
fun LogInScreen(navController : NavHostController) {
    val loginViewModel = LoginViewModel()
    val loginState = LoginState()
   Scaffold(
       topBar = {
           LoginTopBar()
       },
       content = {
           LogInContent (it, loginViewModel, loginState)
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