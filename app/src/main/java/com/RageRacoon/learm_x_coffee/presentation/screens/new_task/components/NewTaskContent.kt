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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.components.*
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.profile.ProfileViewModel
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles.*
import java.time.LocalDate
import javax.inject.Inject


val diasSemana = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")


@Composable
fun NewTaskContent(navController: NavHostController, viewModel: NewTaskViewModel = hiltViewModel()){
    val state = viewModel.state

    var stadoDialog = remember {
        mutableStateOf(true)
    }
    val iconsHabitsList: List<Painter> = listOf(
        painterResource(R.drawable.run),
        painterResource(R.drawable.fitnesst),
        painterResource(R.drawable.coffee_one),
        painterResource(R.drawable.job),
        painterResource(R.drawable.book),
    )
    var iconSeleted = remember{
        mutableStateOf(true)
    }
    var intIconoSeleted =  remember {
        mutableStateOf(0)
    }
    var dateUtiles = DateUtiles()

    MyDialogIconsList(iconSeleted,intIconoSeleted)

    println(intIconoSeleted)
    
  /*MyDialog(
        estado = stadoDialog,
        fun01 = {viewModel.isAHabit(true)},
        accionFuncion01 = "Hábito",
        fun02 = {viewModel.isAHabit(false)},
       accionFuncion02 = "Es una tarea?"
    )*/
    Box(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxWidth()
        .height(60.dp),
        contentAlignment = Alignment.Center) {
        if (state.itIsAHabit){
            Text(text = "Nuevo hábito",color= MaterialTheme.colors.background)
        }else{
            Text(text = "Nueva tarea",color= MaterialTheme.colors.background)
        }

    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(contentPadding = PaddingValues(bottom = 6.dp)){
            item {
                Column(modifier = Modifier
                    .height(800.dp)
                    .fillMaxWidth()
                    ,verticalArrangement = Arrangement.Center){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Button(
                            modifier = Modifier.size(55.dp),
                            onClick = { iconSeleted.value=false
                                },
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.coffee_bean),
                                contentDescription = "Icono de la tarea",
                                tint = MaterialTheme.colors.background,
                            )
                        }
                        Spacer(modifier = Modifier.size(5.dp))
                        TextField(
                            value = state.nameEvent,
                            placeholder = { Text(text = "Nombre del hábito") },
                            onValueChange = {
                                viewModel.taskNameImput(it)
                                viewModel.isNameOk = false
                            }
                        )
                    }
                    if (viewModel.isNameOk == true) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "* El nombre no puede estar vacío.",
                            color = MaterialTheme.colors.onError,
                            style = TextStyle(fontSize = 12.sp),
                            modifier = Modifier.padding(horizontal = 83.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(40.dp))
                    if (state.itIsAHabit){
                        DiasSemanaSeleccionable(diasSemana)
                        Spacer(modifier = Modifier.height(15.dp))
                        Box{
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                // Botón 1
                                Button(
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    onClick = {
                                        viewModel.setTaskSchedule("Mañana")
                                        viewModel.isTimeOk = false
                                    },
                                ) {
                                    Text("Mañana", color = MaterialTheme.colors.secondary)
                                }

                                // Botón 2
                                Button(
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    onClick = {
                                        viewModel.setTaskSchedule("Tarde")
                                        viewModel.isTimeOk = false
                                    },
                                ) {
                                    Text("Tarde", color = MaterialTheme.colors.secondary)
                                }

                                // Botón 3
                                Button(
                                    modifier = Modifier.padding(horizontal = 8.dp),
                                    onClick = {
                                        viewModel.setTaskSchedule("Noche")
                                        viewModel.isTimeOk = false
                                    },
                                ) {
                                    Text("Noche", color = MaterialTheme.colors.secondary)
                                }
                            }
                        }
                        if (viewModel.isTimeOk == true) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "* Debe seleccionar una franja horaria.",
                                color = MaterialTheme.colors.onError,
                                style = TextStyle(fontSize = 12.sp),
                                modifier = Modifier.padding(horizontal = 83.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }/*else{
                        Text(text = "Nueva tarea",color= MaterialTheme.colors.background)
                    }*/

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
            onClick = {
                navController.navigate(route = AppScreen.MainScreen.rutaPantalla){
                    popUpTo(AppScreen.MainScreen.rutaPantalla){inclusive = true}
                }
            }
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Icono izquierdo",
                tint = MaterialTheme.colors.background
            )
        }

        Spacer(Modifier.weight(1f))

        IconButton(

            onClick = {
                if(viewModel.isTheNameEmpty() == false){
                    viewModel.isNameOk = true
                }
                if(viewModel.isTheDateEmpty() == false) {
                    viewModel.isDateOk = true
                }
                if(viewModel.isTheTimeEmpty() == false){
                    viewModel.isTimeOk = true
                }
                if(viewModel.isTheNameEmpty() == true && viewModel.isTheTimeEmpty() == true && viewModel.isTheDateEmpty() == true){
                    viewModel.setIconOfTheList(intIconoSeleted.value)
                    viewModel.createTask()
                    navController.navigate(route = AppScreen.MainScreen.rutaPantalla){
                        popUpTo(AppScreen.MainScreen.rutaPantalla){inclusive = true}
                    }
                }
            }
        ) {
            Icon(
                Icons.Default.Check,
                contentDescription = "Icono derecho",
                tint = MaterialTheme.colors.background
            )
        }
    }
}