package com.nile.pantelis.mynotesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getById(noteId: Int): Note

    @Upsert
    suspend fun upsertNote(note: Note): Long

    @Delete
    suspend fun delete(note: Note): Int
}