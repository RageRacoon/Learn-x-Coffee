package com.RageRacoon.learm_x_coffee.presentation.screens.calendar.components

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel

@Composable
fun CalendarBottomBar(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
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
                    onClick = {
                        navController.navigate(AppScreen.MainScreen.rutaPantalla) }
                ) {
                    Icon( painter =  painterResource(R.drawable.home),
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