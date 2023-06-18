package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.presentation.screens.new_task.NewTaskViewModel

@Composable
fun DiasSemanaSeleccionable(diasSemana: List<String>,viewModel: NewTaskViewModel = hiltViewModel()) {
    var diasSeleccionados by remember { mutableStateOf(setOf<String>()) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Seleccione un día")

            Spacer(modifier = Modifier.height(15.dp))

            for (dia in diasSemana) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = dia in diasSeleccionados,
                            onClick = {
                                viewModel.isDateOk = false
                                diasSeleccionados = if (dia in diasSeleccionados) {
                                    diasSeleccionados - dia


                                } else {
                                    diasSeleccionados + dia
                                }
                                viewModel.addDay(diasSeleccionados)

                            }
                        )
                        .padding(vertical = 4.dp, horizontal = 6.75.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = dia in diasSeleccionados,
                        onClick = null,
                        colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colors.primary)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = dia)
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    if (viewModel.isDateOk == true) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "* Debe seleccionar uno o varios días.",
            color = MaterialTheme.colors.onError,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier.padding(horizontal = 83.dp)
        )
    }

}