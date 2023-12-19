package kaa.alisherbu.listbookstudio.shared.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent
import kaa.alisherbu.listbookstudio.shared.main.MainComponent

interface RootComponent {
    val screenStack: Value<ChildStack<*, ChildScreen>>

    sealed interface ChildScreen {
        class Auth(val component: AuthComponent) : ChildScreen
        class Main(val component: MainComponent) : ChildScreen
    }
}