package com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components

import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.components.Calendar
import java.util.*

@Composable
fun Calendar(
    selectedDate: MutableState<Date>,
    modifier: Modifier = Modifier
) {
    val calendar = Calendar.getInstance()
    calendar.time = selectedDate.value

}