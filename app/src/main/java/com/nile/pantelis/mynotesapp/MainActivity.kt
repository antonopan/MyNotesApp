package com.nile.pantelis.mynotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.nile.pantelis.mynotesapp.data.NoteDatabase
import com.nile.pantelis.mynotesapp.ui.theme.MyNotesAppTheme
import com.nile.pantelis.mynotesapp.view.viewmodels.SwitchScreenViewModel
import com.nile.pantelis.mynotesapp.view.ScreenSelector
import com.nile.pantelis.mynotesapp.view.viewmodels.NoteDataViewModel


class MainActivity : ComponentActivity() {
//    @SuppressLint("ViewModelConstructorInComposable")
    companion object {

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java, "database-name"
        ).build()
        val notesViewModel = NoteDataViewModel(db)

        val switchScreenViewModel = SwitchScreenViewModel()
        setContent {
            MyNotesAppTheme {
                ScreenSelector(
                    switchScreenViewModel = switchScreenViewModel,
                    notesViewModel = notesViewModel,
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
                    )

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
