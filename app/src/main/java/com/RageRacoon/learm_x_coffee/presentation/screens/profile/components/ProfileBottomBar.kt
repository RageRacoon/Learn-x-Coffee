package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ProfileBottomBar(navController: NavHostController,viewModel: ProfileViewModel = hiltViewModel()){
    Row {
        MyButton(
            modifier = Modifier,
            text = "EditarPerfil",
            onClick = {
                //A la hora de navegar a la siguiente pantalla, pasamos por la ruta, una String con todos los datos de usuario, en formato Json. en tiempo real
                navController.navigate(AppScreen.EditProfileScreen.suminstrarUsuario(viewModel.userInfo.toJson()))
            })
        Spacer(modifier = Modifier.width(25.dp))
        MyButton(
            modifier = Modifier,
            text = "LoginOut",
            onClick = {
                viewModel.logOut()
                navController.navigate(route = AppScreen.LogInScreen.rutaPantalla){
                    popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true}
                }
            })
    }

}
