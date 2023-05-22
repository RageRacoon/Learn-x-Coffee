package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun MyRoundImage(imageResource: Int, modifier: Modifier) {

    Image(
        painter = painterResource(id = imageResource),
        contentDescription = "Imagen de perfil",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(192.dp)
            .clip(CircleShape)
    )
}