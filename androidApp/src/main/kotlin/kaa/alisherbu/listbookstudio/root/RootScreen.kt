package kaa.alisherbu.listbookstudio.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import kaa.alisherbu.listbookstudio.auth.AuthScreen
import kaa.alisherbu.listbookstudio.main.MainScreen
import kaa.alisherbu.listbookstudio.shared.root.RootComponent
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
        }
    }
}