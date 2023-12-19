package kaa.alisherbu.listbookstudio.shared.auth

import com.arkivanov.decompose.ComponentContext
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent.Output

class AuthComponentImpl(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : AuthComponent, ComponentContext by componentContext {
    override fun onSignupClicked() {
        output(Output.Signup)
    }

    override fun onSignInClicked() {
        output(Output.SignIn)
    }
}