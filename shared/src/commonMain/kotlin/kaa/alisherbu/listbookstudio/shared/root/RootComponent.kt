package kaa.alisherbu.listbookstudio.shared.root

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent
import kaa.alisherbu.listbookstudio.shared.dialog.MessageDialogComponent
import kaa.alisherbu.listbookstudio.shared.main.MainComponent
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponent
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent

interface RootComponent {
    val screenStack: Value<ChildStack<*, ChildScreen>>
    val dialogSlot: Value<ChildSlot<*, ChildDialog>>
    fun onBackClicked(toIndex: Int)

    sealed interface ChildScreen {
        class Auth(val component: AuthComponent) : ChildScreen
        class Main(val component: MainComponent) : ChildScreen
        class Signup(val component: SignupComponent) : ChildScreen
        class SignIn(val component: SignInComponent) : ChildScreen
    }

    sealed interface ChildDialog {
        class Message(val component: MessageDialogComponent) : ChildDialog
    }
}