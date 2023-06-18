package com.RageRacoon.learm_x_coffee.presentation.screens.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel
import org.checkerframework.checker.units.qual.m
import kotlin.math.roundToInt


@SuppressLint("UnrememberedMutableState")
@Composable
fun MyHabitBox(task:Task, viewModel: MainViewModel = hiltViewModel()) {

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

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(75.dp)){
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
                Column (
                    modifier = Modifier
                        .weight(0.65f)
                ){
                    Text(text = task.nameEvent.take(20),
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.background,
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(22.dp),
                        fontWeight = FontWeight.Bold,
                        textDecoration = if (task.finished) TextDecoration.LineThrough else TextDecoration.None)
                    }
            }

        }
    }
}