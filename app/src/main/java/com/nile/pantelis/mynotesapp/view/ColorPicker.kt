package com.nile.pantelis.mynotesapp.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPicker(
    closeModal: () -> Unit,
    visible: Boolean,
    notesViewModel: NoteDataViewModel
) {
    // Only compose the ModalBottomSheet if 'visible' is true
    if (!visible) return

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    LaunchedEffect(true) {
        if (!visible) {
            sheetState.hide()
        }
    }

    ModalBottomSheet(
        onDismissRequest = {
            // This callback runs when the user taps outside the sheet or swipes it down
            closeModal()
        },
        sheetState = sheetState,
        dragHandle = null, // Set dragHandle to null if you don't want the default handle
        containerColor = Color.Gray // Apply background color here
    ) {
        // This is your content box, which slides in and out with the sheet animation
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray) // Ensure background covers the whole area
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            val colors = listOf(
                Color(0x86FF0000), // Red
                Color(0x86FF7F00), // Orange
                Color(0xBAFFFB00), // Yellow
                Color(0x86088008), // Green
                Color(0x8604F681), // Spring Green
                Color(0x8600FFFF), // Cyan
                Color(0x86007FFF), // Azure
                Color(0xFF3A3A3C), // Blue
//                Color(0x867F00FF), // Violet
                Color(0x86FF00FF), // Magenta
                Color(0x86FF007F)  // Rose
            )
            FlowRow (modifier = Modifier.padding(32.dp)) {
                for (i in 0..9) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(color = Color.Gray)
                            .background(color = colors[i])
                            .size(42.dp)
                            .clickable(onClick = {
                                notesViewModel.onColorChange(colors[i])
                                Log.d("Color", "${notesViewModel.currentNote.value!!.color}")
                            }
                            ),
                    ){

                    }
                }
            }
        }
    }
}
