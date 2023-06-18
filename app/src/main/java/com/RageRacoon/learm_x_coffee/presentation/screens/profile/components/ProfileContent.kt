package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            //Imagen de fondo con efecto borroso.
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(192.dp)
                    .blur(
                        radiusX = 10.dp,
                        radiusY = 10.dp
                    ),
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
                //Si el usuario tiene foto de perfil, la muestra.
                if (viewModel.userInfo.img != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(192.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(2.dp, MaterialTheme.colors.primary),
                                CircleShape
                            ),
                        model = viewModel.userInfo.img,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(text = viewModel.userInfo.userName, fontSize = 28.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize()
                        .padding(horizontal = 35.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
                }
                else {
                    //Si no se tiene foto de perfil muestra un mapache como imagen por defecto.
                    Spacer(modifier = Modifier.height(18.dp))
                    MyRoundImage(R.drawable.sprite_racoon, modifier = Modifier)
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(text = viewModel.userInfo.userName, fontSize = 28.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize()
                        .padding(horizontal = 35.dp), textAlign = TextAlign.Center, fontWeight = FontWeight.Medium)
                }
            }
        }
        //Correo electrónico y descripción del usuario.
        Spacer(modifier = Modifier.height(2.dp))
        Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){
            Text(text = viewModel.userInfo.correo, fontSize = 14.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize()
                .padding(horizontal = 35.dp), textAlign = TextAlign.Center, fontStyle = FontStyle.Italic)
        }
        Spacer(modifier = Modifier.height(35.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Text(viewModel.userInfo.description, fontSize = 18.sp, color = MaterialTheme.colors.primary, modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 35.dp), textAlign = TextAlign.Justify)

        }
        Spacer(modifier = Modifier.height(30.dp))

        //Botón que redirige a la pantalla de editar perfil.
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Button(
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                onClick = {
                    //A la hora de navegar a la siguiente pantalla, pasamos por la ruta, una String con todos los datos de usuario, en formato Json. en tiempo real
                    navController.navigate(
                        AppScreen.EditProfileScreen.suminstrarUsuario(viewModel.userInfo.toJson()))
                }){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Create, contentDescription = "Favorite Icon", tint = MaterialTheme.colors.secondary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Editar perfil", color = MaterialTheme.colors.secondary)
                }

            }
        }
    }
    //Botones de desplazamiento.
    TopAppBar(
        modifier = Modifier
            .height(56.dp)
            .background(Color.Transparent),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        contentPadding = PaddingValues(bottom = 8.dp)
    ){

        //Botón que lleva a la pantalla principal.
        IconButton(
            onClick = {
                navController.navigate(route = AppScreen.MainScreen.rutaPantalla){
                    popUpTo(AppScreen.MainScreen.rutaPantalla){inclusive = true}
                }
            }
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Icono izquierdo",
                tint = MaterialTheme.colors.primary
            )
        }

        Spacer(Modifier.weight(1f))

        //Botón que lleva a la pantalla de inicio de sesión.
        IconButton(onClick = {
            viewModel.logOut()
            navController.navigate(route = AppScreen.LogInScreen.rutaPantalla){
                popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true}
            }
        }) {
            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Icono derecho",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}
