package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@Composable
fun ScreenSelector(
    switchScreenViewModel: SwitchScreenViewModel,
    modifier: Modifier,
    notesViewModel: NoteDataViewModel
) {
    Box(
        modifier = modifier
    ) {

        when (switchScreenViewModel.currentState()) {
            AppState.WriteScreen -> {
                NoteScreen(
                    switchScreenViewModel = switchScreenViewModel,
                    notesViewModel = notesViewModel
                )
            }

            AppState.ViewScreen -> {
                MainNotesList(
                    switchScreenViewModel = switchScreenViewModel,
                    notesViewModel = notesViewModel
                )
            }
        }
    }
}