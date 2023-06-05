package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


/**
 * Funcion composable, que muestra una topBar personalizada.
 *
 * @param title String que se va a mostrar, en la top bar.
 * @param whitIcon Booleano que indica si la top bar va a tener ocono o no
 */
@Composable
fun MyTopBar(
    title: String,
    whitIcon: Boolean = false,
    navController: NavHostController? = null
){
    TopAppBar(
        backgroundColor =  MaterialTheme.colors.primary,
        title = {
            Text(text= title,
            color = MaterialTheme.colors.background)
        },
        navigationIcon = {
            if (whitIcon){
                IconButton(onClick = {navController?.popBackStack()}) { //Este valor puede lleagr a ser null, y evitar el NPE
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colors.background
                    )
                }
            }

        }
    )

}