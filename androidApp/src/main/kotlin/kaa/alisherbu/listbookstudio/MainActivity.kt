package kaa.alisherbu.listbookstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import kaa.alisherbu.listbookstudio.root.RootScreen
import kaa.alisherbu.listbookstudio.shared.root.RootComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent = RootComponentImpl(defaultComponentContext())
        setContent {
            RootScreen(rootComponent)
        }
    }
}
