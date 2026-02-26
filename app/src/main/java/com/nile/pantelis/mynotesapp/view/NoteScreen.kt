package com.nile.pantelis.mynotesapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    switchScreenViewModel: SwitchScreenViewModel = viewModel(),
    notesViewModel: NoteDataViewModel
) {
    var openModal: Boolean by remember { mutableStateOf(false) }

    val note by notesViewModel.currentNote.collectAsState()

    DisposableEffect(Unit) {
        notesViewModel.startAutoSave()

        onDispose {
            notesViewModel.stopAutoSave()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color((note?.color?.toInt() ?: 0xFF2C2C2E.toInt())))

    ) {
        Column {
            Row {
                TopBar(
                    onBackPressed = {
                        switchScreenViewModel.switchScreen(state = AppState.ViewScreen)
                    },
                    onPinPressed = {}
                )
            }

            TextField(
                value = note?.title ?: "",
                onValueChange = notesViewModel::onTitleChange,
                placeholder = { Text("Enter your title") },
                maxLines = 2,
                textStyle = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                )
            )


            val scrollState = rememberScrollState()

            TextField(
                value = notesViewModel.currentNote.value?.content ?: "",
                onValueChange = { notesViewModel.onContentChange(it) },
                placeholder = { Text("Start typing...") },
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 8.dp),
                singleLine = false,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                )
            )

        }


        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomBar(
                onColorButtonPressed = { openModal = true },
                onTextFormatPressed = {},
                onMenuPressed = {
                    notesViewModel.deleteNote {
                        switchScreenViewModel.switchScreen(state = AppState.ViewScreen)
                    }
                }
            )
        }
    }

    ColorPicker(
        closeModal = { openModal = changeModal(openModal) },
        visible = openModal,
        notesViewModel = notesViewModel
    )
}

private fun changeModal(openModal: Boolean): Boolean {
    openModal != openModal
    return openModal
}
