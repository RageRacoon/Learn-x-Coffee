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
        accionFuncion01 = "galeria",
        fun02 = { viewModel.takeAPicture() },
        accionFuncion02 = "camara"
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if( viewModel.imgUri != ""){ //Si la uri es diferente de vacio es porque el usuario a seleccionadu una img
            AsyncImage(
                model = viewModel.imgUri,
                contentDescription="Imagen seleccionada",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(192.dp)
                    .clip(CircleShape)
                    .clickable { stadoDialog.value = true }
            )
        }
        else{
            MyRoundImage(
                imageResource = R.drawable.sprite_racoon,
                modifier = Modifier.clickable {
                    stadoDialog.value = true//En emulador no funciona, da pete
                })

        }

        MyTextField(
            modifier = Modifier.padding(top = 25.dp),
            texto =  state.username,
            onValueChange = { viewModel.userNameImput(it) },
            label = "Nombre de usuario",
            icon = Icons.Default.Person,
        )
        Button(onClick = {
            viewModel.clickEdit()
        }) {
            Text(text = "UpdatePerfil")
        }
    }

}