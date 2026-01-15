package com.nile.pantelis.mynotesapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.MainActivity
import com.nile.pantelis.mynotesapp.data.Note
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NotesList(
    notes: List<Note>,
    modifier: Modifier,
    viewModel: SwitchScreenViewModel
) {
    val noteViewModel = MainActivity.NotesViewModel
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 items per row
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(notes, ) { note ->
            NoteCard(note, {
                viewModel.switchScreen(AppState.WriteScreen)
                noteViewModel.onTitleChange(note.title)
                noteViewModel.onContentChange(note.content)
//                noteViewModel.onColorChange(note.Color)
            }) // Your composable for displaying a Note
        }
    }
}


