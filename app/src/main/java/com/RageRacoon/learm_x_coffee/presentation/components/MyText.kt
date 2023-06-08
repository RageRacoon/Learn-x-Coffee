package com.RageRacoon.learm_x_coffee.presentation.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 *  Objeto composable.
 *
 * @param nivel El primer número a sumar.
 * @param texto El segundo número a sumar.
 */

@Composable
fun MyText(
    nivel: Int,
    texto: String
){
    if (nivel==1){
        Text(texto, fontSize = 28.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize() // Ajusta el tamaño del texto según su contenido
            .padding(horizontal = 35.dp), textAlign = TextAlign.Center)
    }else if (nivel==2){
        Text(texto, fontSize = 18.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize() // Ajusta el tamaño del texto según su contenido
            .padding(horizontal = 35.dp), textAlign = TextAlign.Center)
    }else
        Text(texto, fontSize = 14.sp, color = MaterialTheme.colors.primary, modifier = Modifier.wrapContentSize() // Ajusta el tamaño del texto según su contenido
            .padding(horizontal = 35.dp), textAlign = TextAlign.Center)
}
