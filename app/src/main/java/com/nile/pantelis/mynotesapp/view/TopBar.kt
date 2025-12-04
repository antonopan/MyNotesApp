package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.R

@Composable
fun TopBar(
    onBackPressed: () -> Unit,
    onPinPressed: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackPressed) {
            Icon(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "arrow_back",
                tint = MaterialTheme.colorScheme.onPrimary // or onSurface if preferred
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onPinPressed) {
                Icon(
                    painter = painterResource(R.drawable.pin),
                    contentDescription = "pin",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(onBackPressed = {}, onPinPressed = {})
}
