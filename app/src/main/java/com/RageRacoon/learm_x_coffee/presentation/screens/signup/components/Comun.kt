package com.RageRacoon.learm_x_coffee.presentation.screens.signup.components

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.RageRacoon.learm_x_coffee.R
import com.RageRacoon.learm_x_coffee.presentation.screens.signup.SingUpViewModel

@Composable
fun Icons(string: String, viewModel: SingUpViewModel = hiltViewModel()) {
    if (string.length >= 6) {
        Icon(
            painter = painterResource(id = R.drawable.bx_lock_alt),
            contentDescription = "Icono izquierdo",
            tint = MaterialTheme.colors.primary
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.bx_lock_open_alt),
            contentDescription = "Icono izquierdo",
            tint = MaterialTheme.colors.primary
        )
    }
    if (!string.isEmpty() && viewModel.validateConfirmPassword() == true) {
        Icon(
            painter = painterResource(id = R.drawable.bxs_lock_alt_relleno),
            contentDescription = "Icono izquierdo",
            tint = MaterialTheme.colors.primary
        )
    }
}