package com.nile.pantelis.mynotesapp.view.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nile.pantelis.mynotesapp.domain.AppState

class SwitchScreenViewModel(): ViewModel() {
    private var _screenState by mutableStateOf(AppState.ViewScreen)
    fun switchScreen(state: AppState) {
        this._screenState = state
        Log.d("TESTING", "YOLANDA")
    }

    fun currentState(): AppState {
        return _screenState
    }
}