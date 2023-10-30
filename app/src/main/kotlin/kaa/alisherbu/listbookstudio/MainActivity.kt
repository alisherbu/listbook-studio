package kaa.alisherbu.listbookstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kaa.alisherbu.listbookstudio.ui.theme.ListbookStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListbookStudioTheme {
            }
        }
    }
}
