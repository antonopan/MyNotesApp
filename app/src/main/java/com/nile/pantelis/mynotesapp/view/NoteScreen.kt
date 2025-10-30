package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nile.pantelis.mynotesapp.domain.AppState

@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = NoteViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column() {
            RemButton (onClick = {viewModel.switchScreen(state = AppState.ViewScreen)})
            TextField(
                value = "text",
                onValueChange = { "text = it" },
//            label = { Text("Enter text") },
                placeholder = { Text("Enter your title") },
                textStyle = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                maxLines = 2, // Use this instead of lineLimits
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            )

            val scrollState = rememberScrollState()

            TextField(
                value = "text this thing",
                onValueChange = { "text = it" },
//            label = { Text("Enter text") },
                placeholder = { Text("Start typing...") },
                textStyle = TextStyle(color = Color.Blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp) // fixed visible height
                    .verticalScroll(scrollState) // enable scrolling
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                singleLine = false
            )
        }
    }
}



@Preview
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}