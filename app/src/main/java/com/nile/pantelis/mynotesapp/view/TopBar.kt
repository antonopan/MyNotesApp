package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.mynotesapp.R

@Composable
fun TopBar(
    onBackPressed: () -> Unit,
    onPinPressed: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            modifier = Modifier.padding(all = 3.dp), onClick = onBackPressed
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_back),
                contentDescription = "arrow_back",
            )
        }
        Row (verticalAlignment = Alignment.CenterVertically) {
            Button(
                modifier = Modifier
                    .padding(all = 3.dp)
                ,
                onClick = onPinPressed,
            ) {
                Icon(
                    painter = painterResource(R.drawable.pin),
                    contentDescription = "pin",
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