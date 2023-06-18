package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyDialog (
    estado: MutableState<Boolean>,
    fun01: ()->Unit,
    accionFuncion01: String,
    fun02: ()->Unit,
    accionFuncion02: String,
){
    if (estado.value == true){
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .height(192.dp),
            onDismissRequest = {estado.value = false},
            title = { Text(text = "Seleccione una opción", fontSize = 18.sp, color = MaterialTheme.colors.primary, modifier = Modifier.padding(horizontal = 35.dp), textAlign = TextAlign.Center)},
            buttons = {
                Spacer(modifier = Modifier.height(50.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Button(
                        modifier = Modifier.width(135.dp),
                        onClick = {
                            estado.value = false
                            fun01() }) {
                        Text(text = accionFuncion01)
                    }
                    Button(
                        modifier = Modifier.width(135.dp),
                        onClick = {
                            estado.value = false
                            fun02() }) {
                        Text(text = accionFuncion02)
                    }
                }
            }
        )
    }
}