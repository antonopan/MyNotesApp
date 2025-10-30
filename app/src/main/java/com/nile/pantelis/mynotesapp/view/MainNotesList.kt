package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.data.demoNotes
import com.nile.pantelis.mynotesapp.domain.AppState

@Composable
fun MainNotesList(
    viewModel: NoteViewModel
){
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            AddButton(
            onClick = { viewModel.switchScreen(AppState.WriteScreen) }
            )
        })
    { innerPadding ->
        NotesList(
            modifier = Modifier.padding(innerPadding),
            notes = demoNotes
        )
    }
}