package com.RageRacoon.learm_x_coffee.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.RageRacoon.learm_x_coffee.presentation.ui.theme.TransparenteBlanco

@Composable
fun MyButton(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit,
    icon: ImageVector = Icons.Default.Create,
    enabled: Boolean = true
) {

    Button(
        modifier = modifier.background(TransparenteBlanco),
        onClick = { onClick() },
        enabled = enabled
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }

}

@Composable
@Preview
fun MyButtonPrevew(){
    MyButton(modifier = Modifier, text = "hi", onClick = { /*TODO*/ })
}