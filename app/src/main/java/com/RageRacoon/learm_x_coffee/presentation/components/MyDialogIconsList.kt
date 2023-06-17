package com.RageRacoon.learm_x_coffee.presentation.components

import android.annotation.SuppressLint
import android.content.ClipData.Item
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.graphics.createBitmap
import com.RageRacoon.learm_x_coffee.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun MyDialogIconsList(
        estado: MutableState<Boolean>,
         resultadoPosicionIconoSelecionado : MutableState<Int>
    ){
    val iconsHabitsList: List<Painter> = listOf(
        painterResource(R.drawable.run),
        painterResource(R.drawable.fitnesst),
        painterResource(R.drawable.coffee_one),
        painterResource(R.drawable.job),
        painterResource(R.drawable.book),
    )
        if (estado.value == false){
            AlertDialog(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
                onDismissRequest = {estado.value = true},
                title = { MyText(nivel = 1, texto = "Selecciona un icono")},
                buttons = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ){
                        for (i:Int in iconsHabitsList.indices){
                            Box {
                                Button(
                                    modifier = Modifier.size(75.dp),
                                    onClick = {
                                        resultadoPosicionIconoSelecionado.value = i
                                        estado.value = true
                                        println("Seleccionado desde la alert dialog: " +
                                                resultadoPosicionIconoSelecionado)
                                    },
                                    enabled = true
                                ) {
                                    Icon(
                                        painter = iconsHabitsList[i],
                                        contentDescription = "Iconode la tarea"
                                    )
                                }

                            }
                            Spacer(modifier = Modifier.size(5.dp))
                        }
                    }
                }
            )
        }
    }