package com.RageRacoon.learm_x_coffee.presentation.components

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.RageRacoon.learm_x_coffee.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.google.api.Context
import kotlin.math.roundToInt

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyHabitBoxPredi(task: Task, viewModel: MainViewModel = hiltViewModel()) {
    //Posicion en pantalla
    var offsetX by remember { mutableStateOf(0f) }
    val initialOffsetX = 0f
    var maxOffsetX = 100f
    var minOffsetX = -100f

    // Iconos de los habitos
    val iconsHabitsList: List<Painter> = listOf(
        painterResource(R.drawable.run),
        painterResource(R.drawable.fitnesst),
        painterResource(R.drawable.coffee_one),
        painterResource(R.drawable.job),
        painterResource(R.drawable.book),
    )
    val doneIconDrawable: Painter = painterResource(R.drawable.trophy)
    val dontDoneIconDrawable: Painter = painterResource(R.drawable.coffee_bean)


    val habitNotDoneText:String = "Mañana más"
    val habitNotFinishedText:String = "A por ello!"
    val habitFinishedText:String = "Bien hecho!"
    var textOfTheHabit  by remember { mutableStateOf(habitNotFinishedText) }


    var habitDone by remember { mutableStateOf(task.done) }
    val defaulrErrorColor : Color = MaterialTheme.colors.onError
    val doneColor : Color = MaterialTheme.colors.error
    val dafultColorBg:Color = MaterialTheme.colors.background
    val taskFinisehdColor:Color =  MaterialTheme.colors.onBackground


    val defaulrBgColor : Color = MaterialTheme.colors.primary
    var bgColor by remember { mutableStateOf<Color>(defaulrBgColor)}
    var taskColor by remember { mutableStateOf<Color>(dafultColorBg)}


    val selectedIcon : Painter? = iconsHabitsList[task.intOfArrayOfIcons]

    Box(modifier = Modifier.fillMaxWidth()
        .height(75.dp)
        .draggable(
            orientation = Orientation.Horizontal,
            state = rememberDraggableState { delta ->

                val newOffsetX = offsetX + delta
                if (!task.finished && !task.done){
                    offsetX = newOffsetX.coerceIn(minOffsetX, maxOffsetX)
                    if (offsetX == maxOffsetX) {
                        task.finished = true
                        task.done = true
                        bgColor = taskFinisehdColor
                        taskColor = doneColor
                        task.streak = task.streak+1
                        offsetX = initialOffsetX
                        textOfTheHabit= habitFinishedText
                        viewModel.updateTask(task)
                    } else if (offsetX == minOffsetX) {
                        task.finished = true
                        task.done = false
                        bgColor = taskFinisehdColor
                        taskColor = defaulrErrorColor
                        task.streak = 0
                        offsetX = initialOffsetX
                        textOfTheHabit = habitNotDoneText
                        viewModel.updateTask(task)
                    }
                }else if(task.finished && task.done){
                    maxOffsetX = 0f
                    offsetX = newOffsetX.coerceIn(minOffsetX, maxOffsetX)
                    if (offsetX == minOffsetX) {
                        task.finished = false
                        task.done = false
                        bgColor = defaulrBgColor
                        taskColor = dafultColorBg
                        task.streak = task.streak-1
                        offsetX = initialOffsetX
                        textOfTheHabit= habitNotFinishedText
                        viewModel.updateTask(task)
                    }

                }else if(task.finished && !task.done){
                    minOffsetX = 0f
                    offsetX = newOffsetX.coerceIn(minOffsetX, maxOffsetX)
                    if (offsetX == maxOffsetX) {
                        task.finished = false
                        task.done = false
                        bgColor = defaulrBgColor
                        taskColor = dafultColorBg
                        task.streak = task.streak
                        offsetX = initialOffsetX
                        textOfTheHabit= habitNotFinishedText
                        viewModel.updateTask(task)
                    }
                }
            }
        )
        .offset { IntOffset(offsetX.roundToInt(), 0) }
    ){
        Surface(
            color = bgColor,
            modifier = Modifier
                .padding(end = 5.dp, start = 5.dp)
                .fillMaxWidth()
                .height(75.dp)
                .clip(RoundedCornerShape(16.dp))

        ){
            Row() {
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.25f)
                ) {
                    selectedIcon?.let{
                            drawable -> Icon(
                        painter = drawable,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        tint = if (task.finished) {
                            if (task.done) {
                                doneColor
                            } else {
                                defaulrErrorColor
                            }
                        } else {
                            MaterialTheme.colors.background
                        }
                    )
                    }

                }
                Column (modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.74f)){
                    Text(text = task.nameEvent,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontWeight = FontWeight.Bold,
                        textDecoration = if (task.finished)TextDecoration.LineThrough else TextDecoration.None)
                    Row() {
                        Icon(
                            painter = if (task.done) doneIconDrawable else dontDoneIconDrawable,
                            contentDescription = "",
                            tint = if (task.finished) {
                                if (task.done) {
                                    doneColor
                                } else {
                                    defaulrErrorColor
                                }
                            } else {
                                MaterialTheme.colors.background
                            }
                        )
                        Text(text = if (task.finished) {
                            if (task.done) {
                                habitFinishedText
                            } else {
                                habitNotDoneText
                            }
                        } else {
                            habitNotFinishedText
                        },
                            color = if (task.finished) {
                                if (task.done) {
                                    doneColor
                                } else {
                                    defaulrErrorColor
                                }
                            } else {
                                MaterialTheme.colors.background
                            },
                        )
                    }

                    Text(text = "Racha de " + task.streak +" dias",
                        color = if (task.finished) {
                            if (task.done) {
                                doneColor
                            } else {
                                defaulrErrorColor
                            }
                        } else {
                            MaterialTheme.colors.background
                        },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(end = 5.dp),
                    )

                }
            }

        }
    }
}