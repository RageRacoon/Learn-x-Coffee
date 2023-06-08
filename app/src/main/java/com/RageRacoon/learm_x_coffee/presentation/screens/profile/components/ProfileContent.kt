package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.components.MyRoundImage
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileViewModel


@Composable
fun ProfileContent(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(){
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(192.dp),
                painter = painterResource(id = R.drawable.banner_perfil01),
                contentDescription = "Banner imagen",
                contentScale = ContentScale.Crop,
                alpha = 0.75F
                )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 90.dp)
            ) {
                if (viewModel.userInfo.img != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(192.dp)
                            .clip(CircleShape),
                        model = viewModel.userInfo.img,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    MyText(nivel = 1, texto = viewModel.userInfo.userName)
                }
                else {
                    MyRoundImage(R.drawable.sprite_racoon, modifier = Modifier)
                    Spacer(modifier = Modifier.height(25.dp))
                    MyText(nivel = 1, texto = viewModel.userInfo.userName)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){
            MyText(nivel = 3,texto = viewModel.userInfo.correo)
        }
        Spacer(modifier = Modifier.height(35.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            MyText(nivel = 2, texto = viewModel.userInfo.description)

        }
        Spacer(modifier = Modifier.height(50.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            MyButton(
                modifier = Modifier,
                text = "EditarPerfil",
                onClick = {
                    //A la hora de navegar a la siguiente pantalla, pasamos por la ruta, una String con todos los datos de usuario, en formato Json. en tiempo real
                    navController.navigate(
                        AppScreen.EditProfileScreen.suminstrarUsuario(viewModel.userInfo.toJson()))
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
}
