package kaa.alisherbu.listbookstudio.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import kaa.alisherbu.listbookstudio.auth.AuthScreen
import kaa.alisherbu.listbookstudio.dialog.MessageDialog
import kaa.alisherbu.listbookstudio.main.MainScreen
import kaa.alisherbu.listbookstudio.shared.root.RootComponent
import kaa.alisherbu.listbookstudio.shared.root.RootComponent.ChildDialog
import kaa.alisherbu.listbookstudio.shared.root.RootComponent.ChildScreen
import kaa.alisherbu.listbookstudio.signin.SignInScreen
import kaa.alisherbu.listbookstudio.signup.SignupScreen

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.screenStack,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is ChildScreen.Auth -> AuthScreen(child.component)
            is ChildScreen.Main -> MainScreen(child.component)
            is ChildScreen.SignIn -> SignInScreen(child.component)
            is ChildScreen.Signup -> SignupScreen(child.component)
            ChildScreen.Undefined -> ProgressIndicator()
        }
    }
    val dialogSlot by component.dialogSlot.subscribeAsState()
    dialogSlot.child?.instance?.also { childDialog ->
        when (childDialog) {
            is ChildDialog.Message -> {
                MessageDialog(childDialog.component)
            }
        }
    }
}

@Composable
internal fun ProgressIndicator() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(80.dp)
                .padding(16.dp),
        )
    }
}
