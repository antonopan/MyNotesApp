package com.nile.pantelis.mynotesapp.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.data.demoNotes
import com.nile.pantelis.mynotesapp.domain.AppState

@Composable
fun ScreenSelector (
    viewModel: NoteViewModel,
    modifier: Modifier
) {
    when (viewModel.currentState()) {
        AppState.WriteScreen -> {
            NoteScreen(viewModel = viewModel)
        }
        AppState.ViewScreen -> {
            MainNotesList(viewModel = viewModel)
        }
    }
}