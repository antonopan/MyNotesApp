package com.nile.pantelis.mynotesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id = :noteId")
    fun getById(noteId: Int): Note

    @Upsert
    fun upsertNote(note: Note)

    @Delete
    fun delete(note: Note)
}