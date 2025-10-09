package com.nile.pantelis.mynotesapp.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nile.pantelis.mynotesapp.data.Note

@Composable
fun NoteCard(note: Note) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.Gray)
            .padding(4.dp)

    ){
        Column(
        ) {
            Text(
                note.title,
                fontWeight = FontWeight.Bold

            )
            Text(
                text = note.content,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}