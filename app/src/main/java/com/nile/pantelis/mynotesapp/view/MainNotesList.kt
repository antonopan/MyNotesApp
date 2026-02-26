package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@Composable
fun MainNotesList(
    switchScreenViewModel: SwitchScreenViewModel,
    notesViewModel: NoteDataViewModel,
    modifier: Modifier = Modifier
){
    Scaffold(modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            AddButton(
                onClick = {
                    switchScreenViewModel.switchScreen(AppState.WriteScreen)
                    notesViewModel.onTitleChange("Add Title")
                    notesViewModel.onContentChange("Add Contents")
                    notesViewModel.createNewNote()
                }
            )
        })
    { _ ->
        NotesList(
            notes = notesViewModel.getAllNotes,
            switchScreenViewModel = switchScreenViewModel,
            notesViewModel = notesViewModel
        )
    }
}