package com.RageRacoon.learm_x_coffee.presentation.screens.my_events.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel


@Composable
fun NewTaskContent(viewModel: NewTaskViewModel = hiltViewModel()){
    val state = viewModel.state

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(bottom = 6.dp)){
            item {
                Box(modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(112.dp),
                    contentAlignment = Alignment.Center) {
                  Text(text = "Nueva tarea",color= MaterialTheme.colors.background)
               }
            }
            item {
                Column(modifier = Modifier
                    .height(192.dp)
                    .fillMaxWidth()
                    ,verticalArrangement = Arrangement.Center){
                    TextField(
                        value = state.nameEvent,
                        onValueChange = {
                        viewModel.taskNameImput(it)
                    })
                    Row(horizontalArrangement = Arrangement.Center) {
                        Box(contentAlignment = Alignment.Center) {
                            Row(modifier = Modifier.padding(start = 84.dp, end = 84.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Icono",
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Hola")
                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Icono final",
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "adios")
                            }
                        }
                    }

                }
            }
        }
        }
    TopAppBar(
        modifier = Modifier
            .height(56.dp)
            .background(Color.Transparent),
        elevation = 0.dp,
        backgroundColor = Color.Transparent,
        contentPadding = PaddingValues(bottom = 8.dp)
    ) {
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Default.ExitToApp,
                contentDescription = "Icono izquierdo",
                tint = MaterialTheme.colors.background
            )
        }

        Spacer(Modifier.weight(1f))

        IconButton(
            onClick = {viewModel.createTask()}
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = "Icono derecho",
                tint = MaterialTheme.colors.background
            )
        }
    }
}