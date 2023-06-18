package com.RageRacoon.learm_x_coffee.presentation.screens.calendar.components

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.components.MyHabitBoxPredi
import com.RageRacoon.learm_x_coffee.presentation.screens.calendar.CalendarViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.main.components.MyHabitBox
import com.RageRacoon.learm_x_coffee.utiles.DateUtiles
import java.io.PrintStream

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CalendarContent(
    mainViewModel: MainViewModel = hiltViewModel(),
    calendarViewModel: CalendarViewModel = hiltViewModel(),
    tasks: List<Task>){
    var intTemporal = 1
    val franjaHoraria = mainViewModel.franjaHoraria
    var utiles = DateUtiles()
    Column ( modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(0.0003.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if ( calendarViewModel.intDiasAdelantados != 1) {
                    calendarViewModel.intDiasAdelantados --
                    calendarViewModel.currentDate = utiles.obtenerDiaManana( calendarViewModel.intDiasAdelantados)
                    calendarViewModel.date = utiles.getDateMañana( calendarViewModel.intDiasAdelantados)
                }},
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Flecha izquierda"
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    color = MaterialTheme.colors.secondaryVariant,
                    fontSize = 18.sp,
                    text = calendarViewModel.currentDate
                )
                Text(
                    text = calendarViewModel.date,
                    color = MaterialTheme.colors.secondaryVariant,
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {
                    calendarViewModel.intDiasAdelantados ++
                    calendarViewModel.currentDate = utiles.obtenerDiaManana( calendarViewModel.intDiasAdelantados)
                    calendarViewModel.date = utiles.getDateMañana( calendarViewModel.intDiasAdelantados)

                },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Flecha derecha"
                )
            }
            Spacer(modifier = Modifier.width(25.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

        }
        LazyColumn(
            contentPadding = PaddingValues(bottom = 70.dp, top = 18.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)){
            for(index in franjaHoraria.indices){
                val horario = franjaHoraria[index]

                if(horario == "Mañana"){
                    item{
                        Spacer(modifier = Modifier.height(7.dp))
                        Row(
                            modifier = Modifier.padding(horizontal = 7.dp)
                        ) {
                            Icon(
                                modifier = Modifier.size(34.dp),
                                painter = painterResource(id = R.drawable.wb_twilight_fill0_wght400_grad0_opsz48),
                                contentDescription = "Mañana",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Mañana",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 22.sp,
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
                                modifier = Modifier.size(34.dp),
                                painter = painterResource(id = R.drawable.light_mode_fill0_wght400_grad0_opsz48),
                                contentDescription = "Tarde",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Tarde",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 22.sp,
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
                                modifier = Modifier.size(34.dp),
                                painter = painterResource(id = R.drawable.dark_mode_fill0_wght400_grad0_opsz48),
                                contentDescription = "Noche",
                                tint = MaterialTheme.colors.secondaryVariant
                            )
                            Spacer(modifier = Modifier.width(7.dp))
                            Text(
                                text = "Noche",
                                color = MaterialTheme.colors.secondaryVariant,
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                for (i: Int in tasks.indices) {
                    if (tasks[i].dateOfTheHabits.contains(calendarViewModel.currentDate)) {
                        if (tasks[i].taskSchedule == horario) {
                            item {
                                MyHabitBox(tasks[i])
                            }
                        }
                    }
                }
            }
        }
    }
}