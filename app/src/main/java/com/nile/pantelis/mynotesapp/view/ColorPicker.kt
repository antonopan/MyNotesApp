package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorPicker(
    closeModal: () -> Unit,
    visible: Boolean
) {
    // Only compose the ModalBottomSheet if 'visible' is true
    if (!visible) return

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    // Use LaunchedEffect to handle the programmatic closing when the parent state changes to false
    LaunchedEffect(visible) {
        if (!visible) {
            // This will trigger the collapse animation within the ModalBottomSheet logic
            sheetState.hide()
            // closeModal() is called by the onDismissRequest callback when the animation finishes
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
                Color(0xFFFF0000), // Red
                Color(0xFFFF7F00), // Orange
                Color(0xFFFFFF00), // Yellow
                Color(0xFF7FFF00), // Chartreuse
                Color(0xFF00FF00), // Green
                Color(0xFF00FF7F), // Spring Green
                Color(0xFF00FFFF), // Cyan
                Color(0xFF007FFF), // Azure
                Color(0xFF0000FF), // Blue
                Color(0xFF7F00FF), // Violet
                Color(0xFFFF00FF), // Magenta
                Color(0xFFFF007F)  // Rose
            )
            FlowRow (modifier = Modifier.padding(32.dp)) {
                for (i in 0..9) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(color = colors[i])
                            .size(42.dp)
                            .clickable(onClick = {})
                        ,
                    ){

                    }
                }
            }
        }
    }
}
