package com.nile.pantelis.mynotesapp.data

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "Zouzounia",
    val content: String = "Foo",
    val category: String? = null,
    val color: Long = 0xFF2C2C2E
)