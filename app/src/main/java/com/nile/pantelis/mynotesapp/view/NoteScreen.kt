@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING",
    "TYPE_INTERSECTION_AS_REIFIED_WARNING"
)

package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    viewModel: SwitchScreenViewModel = viewModel(),
    noteViewModel: NoteDataViewModel = viewModel()
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column() {
            Row {
                TopBar(
                    onBackPressed = { viewModel.switchScreen(state = AppState.ViewScreen) },
                    onPinPressed = {}
                )
            }

            TextField(
                value = noteViewModel.titleState.value,
                onValueChange = { noteViewModel.onTitleChange(it) },
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

            Box (
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {


                val scrollState = rememberScrollState()

                TextField(
                    value = "text this thing",
                    onValueChange = { "text = it" },
//            label = { Text("Enter text") },
                    placeholder = { Text("Start typing...") },
                    textStyle = TextStyle(color = Color.Blue),
                    modifier = Modifier
                        .fillMaxSize()
                        .height(200.dp) // fixed visible height
                        .verticalScroll(scrollState) // enable scrolling
                        .padding(horizontal = 8.dp)
                        .fillMaxSize(),
                    singleLine = false
                )
                BottomBar(
                    onColorButtonPressed = {},
                    onTextFormatPressed = {},
                    onMenuPressed = {}
                )
            }
        }
    }
}



@Preview
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}