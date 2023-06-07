package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components


import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.presentation.components.MyDialog
import com.RageRacoon.learm_x_coffee.presentation.components.MyRoundImage
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.EditProfileViewModel
import com.RageRacoon.learm_x_coffee.utiles.ComposeFileProvider

@Composable
fun EditProfileContent(navHostController: NavHostController, viewModel: EditProfileViewModel = hiltViewModel()){

    val state = viewModel.state //States, de esta screen
    viewModel.resultingActivityHandler.handle()

    //Contexto de la aplicacion
    val contexto = LocalContext.current

    //Estado del mensaje del dialogo
    var stadoDialog = remember {
        mutableStateOf(false)
    }

    MyDialog(
        estado = stadoDialog,
        fun01 = { viewModel.getImg() },
        accionFuncion01 = "Galería",
        fun02 = { viewModel.takeAPicture() },
        accionFuncion02 = "Cámara"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 90.dp)
            ) {
                if (viewModel.imgUri != "") {
                    AsyncImage(
                        modifier = Modifier
                            .size(192.dp)
                            .clip(CircleShape)
                            .clickable { stadoDialog.value = true },
                        model = viewModel.imgUri,
                        contentDescription = "User image",
                        contentScale = ContentScale.Crop
                    )
                    MyTextField(
                        modifier = Modifier.padding(top = 25.dp).size(width = 325.dp, height = 60.dp),
                        texto =  state.username,
                        onValueChange = { viewModel.userNameImput(it) },
                        label = "Nombre de usuario",
                        icon = Icons.Default.Person,
                    )
                }
                else {
                    MyRoundImage(R.drawable.sprite_racoon, modifier = Modifier.clickable { stadoDialog.value = true },)
                    MyTextField(
                        modifier = Modifier.padding(top = 25.dp).size(width = 325.dp, height = 25.dp),
                        texto =  state.username,
                        onValueChange = { viewModel.userNameImput(it) },
                        label = "Nombre de usuario",
                        icon = Icons.Default.Person,
                    )
                }
                MyTextField(
                    modifier = Modifier.padding(top = 25.dp).size(width = 325.dp, height = 200.dp),
                    texto =  state.description,
                    onValueChange = { viewModel.descriptionImput(it) },
                    label = "Sobre mí",
                    icon = Icons.Default.Person,
                )
            }
        }
        Button(onClick = {
            viewModel.saveImg()
            viewModel.clickEdit(viewModel.imgUri)
        }) {
            Text(text = "UpdatePerfil")
        }
    }

}