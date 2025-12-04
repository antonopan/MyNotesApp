package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.R

@Composable
fun BottomBar(
    onColorButtonPressed: () -> Unit,
    onTextFormatPressed: () -> Unit,
    onMenuPressed: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onColorButtonPressed,
                modifier = Modifier.padding(3.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.palette),
                    contentDescription = "palette",
                    tint = MaterialTheme.colorScheme.onPrimary // uses theme
                )
            }

            Button(
                onClick = onTextFormatPressed, // fixed callback
                modifier = Modifier.padding(3.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.text_format),
                    contentDescription = "text_format",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }

        Button(
            onClick = onMenuPressed,
            modifier = Modifier.padding(3.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.menu),
                contentDescription = "menu",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(
        onColorButtonPressed = {},
        onTextFormatPressed = {},
        onMenuPressed = {}
    )
}
