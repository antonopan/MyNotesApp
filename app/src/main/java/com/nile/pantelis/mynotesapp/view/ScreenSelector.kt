package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.domain.AppState

@Composable
fun ScreenSelector(
    viewModel: NoteViewModel,
    modifier: Modifier
) {
    Box(
        modifier = modifier
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
}