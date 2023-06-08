package com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.*
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileViewModel
import java.time.LocalDate
import javax.inject.Inject


val diasSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
@Composable
fun NewTaskContent(viewModel: NewTaskViewModel = hiltViewModel()){
    val state = viewModel.state

    var stadoDialog = remember {
        mutableStateOf(true)
    }

    MyDialog(
        estado = stadoDialog,
        fun01 = {viewModel.isAHabit(true)},
        accionFuncion01 = "Hábito",
        fun02 = {viewModel.isAHabit(false)},
        accionFuncion02 = "Tarea"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(bottom = 6.dp)){
            item {
                Box(modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .fillMaxWidth()
                    .height(112.dp),
                    contentAlignment = Alignment.Center) {
                    if (state.itIsAHabit){
                        Text(text = "Nueva habito",color= MaterialTheme.colors.background)
                    }else{
                        Text(text = "Nueva tarea",color= MaterialTheme.colors.background)
                    }

               }
            }
            item {
                Column(modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    ,verticalArrangement = Arrangement.Center){
                    Text(text = "Nombre del habito")
                    TextField(
                        value = state.nameEvent,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        onValueChange = {
                        viewModel.taskNameImput(it)
                    })
                    if (state.itIsAHabit){
                        DiasSemanaSeleccionable(diasSemana)
                    }else{
                        Text(text = "Nueva tarea",color= MaterialTheme.colors.background)
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
            onClick = { /* Acción al pulsar el icono izquierdo */ }
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