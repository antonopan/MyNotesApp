package com.nile.pantelis.mynotesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String = "Title",
    val content: String = "Contents",
    val category: String? = null,
    val color: Long = 0xFF3A3A3C
)