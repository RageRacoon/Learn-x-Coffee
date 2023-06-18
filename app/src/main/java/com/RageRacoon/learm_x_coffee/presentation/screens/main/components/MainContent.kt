package com.RageRacoon.learm_x_coffee.presentation.screens.login.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.components.MyHabitBoxPredi
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainContent(
    //navController: NavHostController,
                viewModel: MainViewModel = hiltViewModel(),
                tasks: List<Task>) {
    val franjaHoraria = viewModel.franjaHoraria

    Row(){
        Text(
            text = viewModel.currentDate,
            color = MaterialTheme.colors.secondaryVariant,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = viewModel.date,
            color = MaterialTheme.colors.secondaryVariant,
            fontSize = 20.sp,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(Modifier.height(20.dp))
        LazyColumn(
            contentPadding = PaddingValues(bottom = 70.dp, top = 18.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for(index in franjaHoraria.indices){
                val horario = franjaHoraria[index]

                if(horario == "Mañana"){
                    item{
                        Spacer(modifier = Modifier.height(7.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 7.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(38.dp),
                                painter = painterResource(id = R.drawable.wb_twilight_fill0_wght400_grad0_opsz48),
                                contentDescription = "Mañana",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Mañana",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                } else if(horario == "Tarde"){
                    item{
                        Spacer(modifier = Modifier.height(7.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 7.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(38.dp),
                                painter = painterResource(id = R.drawable.light_mode_fill0_wght400_grad0_opsz48),
                                contentDescription = "Tarde",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Tarde",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }else if (horario == "Noche"){
                    item{
                        Spacer(modifier = Modifier.height(7.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 7.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(38.dp),
                                painter = painterResource(id = R.drawable.dark_mode_fill0_wght400_grad0_opsz48),
                                contentDescription = "Noche",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Noche",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 24.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                for (i: Int in tasks.indices) {
                    if (tasks[i].dateOfTheHabits.contains(viewModel.currentDate)) {
                        if (tasks[i].taskSchedule == horario) {
                            item {
                                MyHabitBoxPredi(tasks[i])
                            }
                        }
                    }
                }
            }

        }
    }
}