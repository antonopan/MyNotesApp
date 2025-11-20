package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.data.demoNotes
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@Composable
fun MainNotesList(
    viewModel: SwitchScreenViewModel,
    modifier: Modifier = Modifier
){
    Scaffold(modifier = modifier.fillMaxSize(),
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