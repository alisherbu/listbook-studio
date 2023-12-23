package kaa.alisherbu.listbookstudio.shared.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent.Output
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponentImpl
import kaa.alisherbu.listbookstudio.shared.dialog.MessageDialogComponentImpl
import kaa.alisherbu.listbookstudio.shared.main.MainComponentImpl
import kaa.alisherbu.listbookstudio.shared.root.RootComponent.ChildScreen
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponent
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponentImpl
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponentImpl
import kaa.alisherbu.listbookstudio.shared.root.RootComponent.ChildDialog

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val screenNavigation = StackNavigation<ScreenConfig>()
    private val dialogNavigation = SlotNavigation<DialogConfig>()

    override val screenStack: Value<ChildStack<*, ChildScreen>> = childStack(
        source = screenNavigation,
        initialConfiguration = ScreenConfig.Auth,
        handleBackButton = true,
        childFactory = ::createChildScreen
    )

    override val dialogSlot: Value<ChildSlot<*, ChildDialog>> = childSlot(
        source = dialogNavigation,
        handleBackButton = true,
        childFactory = ::createChildDialog,
    )

    override fun onBackClicked(toIndex: Int) {
        screenNavigation.popTo(index = toIndex)
    }

    private fun createChildScreen(
        config: ScreenConfig,
        componentContext: ComponentContext,
    ): ChildScreen = when (config) {
        ScreenConfig.Auth -> {
            ChildScreen.Auth(AuthComponentImpl(componentContext, ::onAuthOutput))
        }

        ScreenConfig.Main -> {
            ChildScreen.Main(MainComponentImpl(componentContext))
        }

        ScreenConfig.SignIn -> {
            ChildScreen.SignIn(SignInComponentImpl(componentContext, ::onSignInOutput))
        }

        ScreenConfig.Signup -> {
            ChildScreen.Signup(SignupComponentImpl(componentContext, ::onSignupOutput))
        }
    }

    private fun createChildDialog(
        config: DialogConfig,
        componentContext: ComponentContext,
    ): ChildDialog = when (config) {
        is DialogConfig.Message -> {
            ChildDialog.Message(
                MessageDialogComponentImpl(
                    componentContext = componentContext,
                    message = config.text,
                    onDismissed = dialogNavigation::dismiss,
                )
            )
        }
    }

    private fun onAuthOutput(output: Output): Unit = when (output) {
        Output.Signup -> {
            screenNavigation.push(ScreenConfig.Signup)
        }

        Output.SignIn -> {
            screenNavigation.push(ScreenConfig.SignIn)
        }
    }

    private fun onSignupOutput(output: SignupComponent.Output): Unit = when (output) {
        SignupComponent.Output.Back -> {
            screenNavigation.pop()
        }

        is SignupComponent.Output.Error -> {
            dialogNavigation.activate(DialogConfig.Message(output.message))
        }
    }

    private fun onSignInOutput(output: SignInComponent.Output): Unit = when (output) {
        SignInComponent.Output.Back -> {
            screenNavigation.pop()
        }

        SignInComponent.Output.Main -> {
            screenNavigation.replaceAll(ScreenConfig.Main)
        }

        is SignInComponent.Output.Error -> {
            dialogNavigation.activate(DialogConfig.Message(output.message))
        }
    }

    private sealed interface ScreenConfig : Parcelable {
        @Parcelize
        data object Auth : ScreenConfig

        @Parcelize
        data object Main : ScreenConfig

        @Parcelize
        data object Signup : ScreenConfig

        @Parcelize
        data object SignIn : ScreenConfig
    }

    private sealed interface DialogConfig : Parcelable {
        @Parcelize
        class Message(
            val text: String,
        ) : DialogConfig
    }
}