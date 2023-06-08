package com.RageRacoon.learm_x_coffee.presentation.screens.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel
import org.checkerframework.checker.units.qual.m
import kotlin.math.roundToInt


@SuppressLint("UnrememberedMutableState")
@Composable
fun MyHabitBox(task:Task, viewModel: MainViewModel = hiltViewModel()) {

    val state = viewModel.state
    var offsetX by remember { mutableStateOf(0f) }
    val initialOffsetX = 0f
    val maxOffsetX = 200f
    val minOffsetX = -200f

    var bgColor by mutableStateOf<Color>(MaterialTheme.colors.onPrimary)

    Box(
        modifier = Modifier
            .height(112.dp)
            .fillMaxWidth()
            .background(bgColor)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    if (!task.finished) {
                        val newOffsetX = offsetX + delta

                        offsetX = newOffsetX.coerceIn(minOffsetX, maxOffsetX)

                        if (offsetX == maxOffsetX) {
                            task.finished = true
                            task.done = true
                            bgColor = Color.Green
                            task.streak++
                            offsetX = initialOffsetX
                            viewModel.onUpdateTask(task)


                        } else if (offsetX == minOffsetX) {
                            task.finished = true
                            task.done = false
                            bgColor = Color.Red
                            task.streak = 0
                            offsetX = initialOffsetX
                            viewModel.onUpdateTask(task)
                        }
                    }
                }
            )
            .offset { IntOffset(offsetX.roundToInt(), 0) }

    ) {
        Text(
            text = task.nameEvent,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            color = MaterialTheme.colors.background
        )
        Text(text = "Racha de " +task.streak+ " dias consecutivos",
        color = MaterialTheme.colors.primary)
    }
}