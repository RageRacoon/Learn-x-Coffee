package com.RageRacoon.learm_x_coffee.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.RageRacoon.learm_x_coffee.presentation.components.MyText
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.components.SinUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(){
    Scaffold(
        topBar = {},
        content = {
                 SinUpContent(it)
        },
        bottomBar = {}

    )
}