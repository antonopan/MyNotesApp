package com.nile.pantelis.mynotesapp.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    val title: String,
    val content: String,
    val category: String?,
    val color: Long = 0xFF2C2C2E,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    )