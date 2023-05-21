package com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.edit_profile.EditProfileViewModel

@Composable
fun EditProfileContent(navHostController: NavHostController, viewModel: EditProfileViewModel = hiltViewModel()){

    val state = viewModel.state //States, de esta screen

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .height(255.dp),
            painter = painterResource(id = R.drawable.sprite_racoon),
            contentDescription = "Img perfil")
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