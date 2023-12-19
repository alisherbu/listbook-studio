package kaa.alisherbu.listbookstudio.shared.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent.Output
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponentImpl
import kaa.alisherbu.listbookstudio.shared.main.MainComponentImpl
import kaa.alisherbu.listbookstudio.shared.root.RootComponent.ChildScreen

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {
    private val screenNavigation = StackNavigation<ScreenConfig>()

    override val screenStack: Value<ChildStack<*, ChildScreen>> = childStack(
        source = screenNavigation,
        initialConfiguration = ScreenConfig.Auth,
        handleBackButton = true,
        childFactory = ::createChildScreen
    )

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
    }

    private fun onAuthOutput(output: Output): Unit = when (output) {
        Output.Signup -> {
            screenNavigation.push(ScreenConfig.Main)
        }

        Output.SignIn -> {
            screenNavigation.push(ScreenConfig.Main)
        }
    }

    private sealed interface ScreenConfig : Parcelable {
        @Parcelize
        data object Auth : ScreenConfig

        @Parcelize
        data object Main : ScreenConfig
    }
}