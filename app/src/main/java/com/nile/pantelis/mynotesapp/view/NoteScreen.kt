@file:Suppress(
    "INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING",
    "TYPE_INTERSECTION_AS_REIFIED_WARNING"
)

package com.nile.pantelis.mynotesapp.view

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    viewModel: SwitchScreenViewModel = viewModel(),
    noteViewModel: NoteDataViewModel = viewModel()
) {
    var openModal: Boolean by remember { mutableStateOf(false) }
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
                placeholder = { Text("Enter your title") },
                maxLines = 2,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            )


            val scrollState = rememberScrollState()

            TextField(
                value = noteViewModel.contentState.value,
                onValueChange = { noteViewModel.onContentChange(it) },
                placeholder = { Text("Start typing...") },
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 8.dp),
                singleLine = false
            )

        }


        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomBar(
                onColorButtonPressed = {openModal = true},
                onTextFormatPressed = {},
                onMenuPressed = {}
            )
        }
    }
    if(openModal) {
        ColorPicker(
            closeModal = { openModal = changeModal(openModal) },
            visible = openModal
        )
    }
}

private fun changeModal(openModal: Boolean): Boolean {
    // This function simply decides what the new state should be
    Log.d("This", openModal.toString())
    return !openModal
}

@Preview
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}