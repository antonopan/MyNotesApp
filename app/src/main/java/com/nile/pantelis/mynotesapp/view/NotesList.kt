package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.data.Note

@Composable
fun NotesList(
    notes: List<Note>,
    modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // 2 items per row
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(notes) { note ->
            NoteCard(note) // Your composable for displaying a Note
        }
    }
}


