package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RemButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier.size(49.dp), onClick = onClick, shape= CircleShape
    ) {
        Text(
            text = "<╯",
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}