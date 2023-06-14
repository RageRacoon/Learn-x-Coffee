package com.RageRacoon.learm_x_coffee.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    background = Brown700,
    primary = mainBrown,
    primaryVariant = Brown200,
    secondary = Brown200,
    onPrimary = Beige200,
    onError = ErrorColor,
    error = DoneColor,
    onBackground = TaskFinished,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    background = SoftBrown200,
    primary = mainBrown,
    primaryVariant = SoftBrown500,
    secondary = SoftBrown200,
    onPrimary = Brown700,
    onError = ErrorColor,
    error = DoneColor,
    onBackground = TaskFinished,

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun LearmxCoffeeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}