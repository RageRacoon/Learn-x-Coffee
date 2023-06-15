package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileViewModel
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun ProfileBottomBar(navController: NavHostController,viewModel: ProfileViewModel = hiltViewModel()){
    val activity = LocalContext.current as? Activity

    //Barra de navegación idéntica a la de la main screen.

    BottomAppBar(
        contentPadding = PaddingValues(start = 5.dp, end = 5.dp),
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(){
                IconButton(
                    modifier = Modifier.size(48.dp).scale(2.5f),
                    onClick = { navController.navigate(AppScreen.NewTaskScreen.rutaPantalla) }
                ) {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "",
                        tint = MaterialTheme.colors.background,

                        )

                }
            }
            Box(){
                IconButton(
                    modifier = Modifier.size(48.dp).scale(2.5f),
                    onClick = { /* Acción para el primer elemento */ }
                ) {
                    Icon(imageVector = Icons.Default.DateRange,
                        contentDescription = "",
                        tint = MaterialTheme.colors.background,
                    )

                }
            }
            Box(){
                IconButton(
                    modifier = Modifier.size(48.dp).scale(2.5f),
                    onClick = {
                    }
                ) {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "",
                        tint = MaterialTheme.colors.background,
                    )

                }
            }

        }
    }

}
