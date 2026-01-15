package com.nile.pantelis.mynotesapp.view.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class NoteDataViewModel: ViewModel() {
    // PRIVATE mutable states
    private var _titleState = mutableStateOf("Zouzounia")
    private var _contentState = mutableStateOf("Foo")
    private var _colorState = mutableStateOf(Color(0xFF2C2C2E))

    // PUBLIC read-only states
    val titleState: State<String> get() = _titleState
    val contentState: State<String> get() = _contentState
    val colorState: MutableState<Color> get() = _colorState

    // Update functions (recommended)
    fun onTitleChange(newValue: String) {
        _titleState.value = newValue
        Log.d("Hello", _titleState.value)
    }

    fun onContentChange(newValue: String) {
        _contentState.value = newValue
    }

    fun onColorChange(newValue: Color) {
        _colorState.value = newValue
    }

}