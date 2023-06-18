package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel


@Composable
fun MainBottomBar(navController: NavHostController, viewModel: MainViewModel = hiltViewModel()) {
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
                        navController.navigate(AppScreen.NewTaskScreen.rutaPantalla) }
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
                    onClick = {
                        navController.navigate(AppScreen.CalendarScreen.rutaPantalla)

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
