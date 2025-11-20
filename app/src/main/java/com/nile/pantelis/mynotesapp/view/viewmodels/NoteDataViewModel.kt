package com.nile.pantelis.mynotesapp.view.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.nile.pantelis.mynotesapp.domain.AppState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import org.jetbrains.annotations.Debug

class NoteDataViewModel: ViewModel() {
    // PRIVATE mutable states
    private var _titleState = mutableStateOf("Zouzounia")
    private var _contentState = mutableStateOf("Foo")
    private var _colorState = mutableStateOf("Bar")

    // PUBLIC read-only states
    val titleState: State<String> get() = _titleState
    val contentState: State<String> get() = _contentState
    val colorState: State<String> get() = _colorState

    // Update functions (recommended)
    fun onTitleChange(newValue: String) {
        _titleState.value = newValue
        Log.d("Hello", _titleState.value)
    }

    fun onContentChange(newValue: String) {
        _contentState.value = newValue
    }

    fun onColorChange(newValue: String) {
        _colorState.value = newValue
    }

}