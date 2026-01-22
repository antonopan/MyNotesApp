package com.nile.pantelis.mynotesapp.data

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val category: String?,
    val color: Color = Color(0xFF2C2C2E),
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    )