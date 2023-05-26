package com.RageRacoon.learm_x_coffee.presentation.screens.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

data class EventStatusIcon (
    val cancelIcon: ImageVector = Icons.Default.Close,
    val doneIcon: ImageVector = Icons.Default.Done,
    var eventIcon: ImageVector = Icons.Default.List,
)