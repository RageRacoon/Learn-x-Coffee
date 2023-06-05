package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
            Text(text = "Seleccione un dia")

            Spacer(modifier = Modifier.height(8.dp))

            for (dia in diasSemana) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = dia in diasSeleccionados,
                            onClick = {
                                diasSeleccionados = if (dia in diasSeleccionados) {
                                    diasSeleccionados - dia


                                } else {
                                    diasSeleccionados + dia
                                }
                                viewModel.addDay(diasSeleccionados)

                            }
                        )
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = dia in diasSeleccionados,
                        onClick = null,
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = dia)
                }
            }
        }
    }
}