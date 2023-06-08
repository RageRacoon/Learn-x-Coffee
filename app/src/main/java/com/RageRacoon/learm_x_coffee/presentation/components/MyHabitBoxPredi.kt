package com.RageRacoon.learm_x_coffee.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.domain.model.Task
import com.RageRacoon.learm_x_coffee.presentation.screens.main.MainViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyHabitBoxPredi() {
    val habitNotFinishedText:String = "A por ello!"
    val habitFinishedText:String = "Bien hecho!"
    val colorFinised: Color = Color.Green
    var bgColor by mutableStateOf<Color>(MaterialTheme.colors.primary)
    Surface(
        modifier = Modifier
            .padding(end = 5.dp, start = 5.dp)
            .fillMaxWidth()
            .height(67.dp)
            .clip(RoundedCornerShape(16.dp)),
        color = bgColor
    ){
        Row() {
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(0.25f)
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    tint = MaterialTheme.colors.background
                )

            }
            Column (modifier = Modifier
                .fillMaxHeight()
                .weight(0.74f)){
                Text(text = "TITULO DE LA ACTIVIDAD",
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold)
                Row() {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "",
                        tint = MaterialTheme.colors.background
                    )
                    Text(text = habitNotFinishedText)
                }

                Text(text = "Racha de dias",
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 5.dp),
                    )

            }
        }

    }
}


@Preview
@Composable
fun MyHabitBoxPrediPreview(){
    MyHabitBoxPredi()
}