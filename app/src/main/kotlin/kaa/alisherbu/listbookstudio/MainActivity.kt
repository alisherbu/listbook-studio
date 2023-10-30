package kaa.alisherbu.listbookstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import kaa.alisherbu.listbook.feature.root.ui.RootScreen
import kaa.alisherbu.listbookstudio.di.DaggerAppComponent
import kaa.alisherbu.listbookstudio.ui.theme.ListbookStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appComponent = DaggerAppComponent
            .factory()
            .create(applicationContext)
        val rootComponent = appComponent.rootComponentFactory(defaultComponentContext())
        setContent {
            ListbookStudioTheme {
                RootScreen(rootComponent)
            }
        }
    }
}
