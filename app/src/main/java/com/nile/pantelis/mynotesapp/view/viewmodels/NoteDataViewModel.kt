package com.nile.pantelis.mynotesapp.view.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nile.pantelis.mynotesapp.data.Note
import com.nile.pantelis.mynotesapp.data.NoteDatabase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
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

    var currentNote: StateFlow<Note?> = noteDraft

    val defaultNote =  Note(title = "Book Ideas", content = "Sci-fi story about time travel", category = "Creative")

    private var isDeleting = false
    private var autoSaveJob: Job? = null

    fun startAutoSave() {
        // Αν υπάρχει ήδη ένα job (π.χ. από προηγούμενη σημείωση), το κλείνουμε
        autoSaveJob?.cancel()

        autoSaveJob = viewModelScope.launch {
            noteDraft
                .filterNotNull()
                .distinctUntilChanged()
                .debounce(600)
                .collect { note ->
                    if (isDeleting) return@collect

                    val generatedId = db.dao().upsertNote(note)
                    if (note.id == 0) {
                        noteDraft.value = noteDraft.value?.copy(id = generatedId.toInt())
                    }
                }
        }
    }

    fun stopAutoSave() {
        autoSaveJob?.cancel()
        autoSaveJob = null
    }

    fun selectNote(note: Note) {
        // Σταματάμε τυχόν παλιό auto-save για ασφάλεια
        stopAutoSave()
        // Ενημερώνουμε το draft με ΟΛΑ τα στοιχεία της σημείωσης (και το ID!)
        noteDraft.value = note
    }

    fun createNewNote() {
        stopAutoSave()
        noteDraft.value = Note() // Reset σε id = 0 και κενά πεδία
    }

    init {
        viewModelScope.launch {
            db.dao().getAll().collect { list ->
                getAllNotes = list
                Log.d("DB NOTES", list.toString())
            }
        }

//        viewModelScope.launch {
//            noteDraft
//                .filterNotNull()
//                .distinctUntilChanged()
//                .debounce(600) // 👈 save after user stops typing
//                .collect { note ->
//                    val generatedId = db.dao().upsertNote(note)
//
//                    if (isDeleting) return@collect
//
//                    if (note.id == 0) {
//                        noteDraft.value = noteDraft.value?.copy(id = generatedId.toInt())
//                    }
//                }
//        }
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
            color = newValue.toArgb().toLong()
        )
    }

    fun deleteNote(onComplete: () -> Unit) {
        Log.d("Note to delete", currentNote.value.toString())
        val noteToDelete = currentNote.value ?: return

        isDeleting = true

        viewModelScope.launch {
            try {
                val result = db.dao().delete(db.dao().getById(noteToDelete.id))
                if (result > 0) {
//                    noteDraft.value = Note()
                    onComplete()
                }
            } finally {
                isDeleting = false
            }
        }

    }
}