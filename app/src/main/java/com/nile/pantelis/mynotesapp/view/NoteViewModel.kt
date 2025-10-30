package com.nile.pantelis.mynotesapp.view

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.nile.pantelis.mynotesapp.domain.AppState

class NoteViewModel() {
    private var state by mutableStateOf(AppState.ViewScreen)
    fun switchScreen(state: AppState) {
        this.state = state
        Log.d("TESTING", "YOLANDA")
    }

    fun currentState(): AppState {
        return state
    }
}