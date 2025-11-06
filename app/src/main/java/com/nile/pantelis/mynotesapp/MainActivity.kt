package com.nile.pantelis.mynotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nile.pantelis.mynotesapp.data.demoNotes
import com.nile.pantelis.mynotesapp.domain.AppState
import com.nile.pantelis.mynotesapp.ui.theme.MyNotesAppTheme
import com.nile.pantelis.mynotesapp.view.AddButton
import com.nile.pantelis.mynotesapp.view.MainNotesList
import com.nile.pantelis.mynotesapp.view.NoteViewModel
import com.nile.pantelis.mynotesapp.view.NotesList
import com.nile.pantelis.mynotesapp.view.ScreenSelector


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = NoteViewModel()
            MyNotesAppTheme {
                ScreenSelector(
                    viewModel = viewModel,
                    modifier = Modifier.safeDrawingPadding()
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
