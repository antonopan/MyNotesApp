package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@Composable
fun ScreenSelector(
    viewModel: SwitchScreenViewModel,
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