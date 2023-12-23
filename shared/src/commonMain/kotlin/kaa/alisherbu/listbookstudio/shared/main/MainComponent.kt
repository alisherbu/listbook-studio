package kaa.alisherbu.listbookstudio.shared.main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kaa.alisherbu.listbookstudio.shared.home.HomeComponent
import kaa.alisherbu.listbookstudio.shared.profile.ProfileComponent

interface MainComponent {
    val screenStack: Value<ChildStack<*, ChildScreen>>

    fun onHomeClicked()

    fun onProfileClicked()

    sealed interface Output

    sealed interface ChildScreen {
        class Home(val component: HomeComponent) : ChildScreen
        class Profile(val component: ProfileComponent) : ChildScreen
    }
}