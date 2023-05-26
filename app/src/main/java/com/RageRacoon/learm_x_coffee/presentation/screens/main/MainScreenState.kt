package com.RageRacoon.learm_x_coffee.presentation.screens.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.ui.graphics.vector.ImageVector

data class MainScreenState (
    val dateTask: String = "",
    val cancelIcon: ImageVector = Icons.Default.Close,
    val doneIcon: ImageVector = Icons.Default.Done
)