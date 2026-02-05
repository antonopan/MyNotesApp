package com.nile.pantelis.mynotesapp.view.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nile.pantelis.mynotesapp.data.Note
import com.nile.pantelis.mynotesapp.data.NoteDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteDataViewModel(private val db: NoteDatabase) : ViewModel() {
    // PRIVATE mutable states
//    private var _titleState = mutableStateOf("Zouzounia")
//    private var _contentState = mutableStateOf("Foo")
//    private var _colorState = mutableStateOf(Color(0xFF2C2C2E))
//
//    // PUBLIC read-only states
//    val titleState: State<String> get() = _titleState
//    val contentState: State<String> get() = _contentState
//    val colorState: MutableState<Color> get() = _colorState

    private val noteDraft = MutableStateFlow<Note?>(Note())
    var getAllNotes by mutableStateOf<List<Note>>(emptyList())
        private set

    val currentNote: StateFlow<Note?> = noteDraft


    init {
        viewModelScope.launch {
            db.dao().getAll().collect { list ->
                getAllNotes = list
            }
        }

        viewModelScope.launch {
            noteDraft
                .filterNotNull()
                .distinctUntilChanged()
                .debounce(600) // 👈 save after user stops typing
                .collect { note ->
                    db.dao().upsertNote(note)
                }
        }
    }


    // Update functions (recommended)
    fun onTitleChange(newValue: String) {
        noteDraft.value = noteDraft.value?.copy(
            title = newValue,
        )
    }

    fun onContentChange(newValue: String) {
        noteDraft.value = noteDraft.value?.copy(
            content = newValue,
        )
    }

    fun onColorChange(newValue: Color) {
//        _colorState.value = newValue
        noteDraft.value = noteDraft.value?.copy(
            color = newValue.value.toLong(),
        )
    }
}