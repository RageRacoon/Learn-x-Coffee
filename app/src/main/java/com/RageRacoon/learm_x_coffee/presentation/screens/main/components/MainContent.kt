package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.presentation.components.MyTextField
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.navigation.NavHostController
import com.RageRacoon.learm_x_coffee.presentation.screens.login.LoginViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Response
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.components.MyButton
import com.RageRacoon.learm_x_coffee.presentation.components.MyHabitBoxPredi
import com.RageRacoon.learm_x_coffee.presentation.navegation.AppScreen
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.EventStatusIcon
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.MyHabitBox
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.time.LocalTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainContent(
    //navController: NavHostController,
                viewModel: MainViewModel = hiltViewModel(),
                tasks: List<Task>){
    Column ( modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "HOY")
        Text(text = viewModel.currentDate)
        Text(text = viewModel.date)
        LazyColumn(
            contentPadding = PaddingValues(bottom = 70.dp, top = 18.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)){
            for (i:Int in tasks.indices){
                if(tasks[i].dateOfTheHabits.contains(viewModel.currentDate)){
                    item {
                        MyHabitBoxPredi(tasks[i])}
                }else{

                }
            }

            /*tasks.forEach { task ->
                item {
                    //task.dateOfTheHabits.forEach{
                      //  if(task.dateOfTheHabits.contains(viewModel.tooday) ){
                    MyHabitBoxPredi(task)
                        //}

                    //}

                }
            }*/
        }
    }
    }




