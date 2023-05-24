package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel

@Composable
fun MainTopBar(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()){
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
                .clickable {
                    navController.navigate(route = AppScreen.ProfileScreen.rutaPantalla){
                        popUpTo(AppScreen.LogInScreen.rutaPantalla){inclusive = true}
                    }
                }) {
            Text(
                text = viewModel.userInfo.userName,
                color =  MaterialTheme.colors.background,
            )
            Spacer(modifier = Modifier.width(16.dp))
            AsyncImage(
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape),
                model = viewModel.userInfo.img,
                contentDescription = "User image",
                contentScale = ContentScale.Crop
            )

        }
    }
}