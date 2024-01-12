package kaa.alisherbu.listbookstudio.shared.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import kaa.alisherbu.listbookstudio.shared.di.AppContainer
import kaa.alisherbu.listbookstudio.shared.di.StoreContainer
import kaa.alisherbu.listbookstudio.shared.home.HomeComponent
import kaa.alisherbu.listbookstudio.shared.home.HomeComponentImpl
import kaa.alisherbu.listbookstudio.shared.main.MainComponent.ChildScreen
import kaa.alisherbu.listbookstudio.shared.main.MainComponent.Output
import kaa.alisherbu.listbookstudio.shared.main.store.Label
import kaa.alisherbu.listbookstudio.shared.profile.ProfileComponentImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainComponentImpl(
    componentContext: ComponentContext,
    private val output: (Output) -> Unit
) : MainComponent, ComponentContext by componentContext {
    private val dispatchers = AppContainer.getAppDispatchers()
    private val mainScope = CoroutineScope(dispatchers.main)
    private val store = instanceKeeper.getStore(StoreContainer::getMainStore)

    init {
        store.labels
            .onEach(::handleLabel)
            .launchIn(mainScope)
    }

    private val screenNavigation = StackNavigation<ScreenConfig>()

    override val screenStack: Value<ChildStack<*, ChildScreen>> = childStack(
        source = screenNavigation,
        initialConfiguration = ScreenConfig.Home,
        handleBackButton = false,
        childFactory = ::createChildScreen,
    )

    private fun handleLabel(label: Label) {

    }

    private fun createChildScreen(
        config: ScreenConfig,
        componentContext: ComponentContext,
    ): ChildScreen {
        return when (config) {
            ScreenConfig.Home -> {
                ChildScreen.Home(HomeComponentImpl(componentContext, ::onHomeOutput))
            }

            ScreenConfig.Profile -> {
                ChildScreen.Profile(ProfileComponentImpl(componentContext))
            }
        }
    }

    override fun onHomeClicked() {
        screenNavigation.bringToFront(ScreenConfig.Home)
    }

    override fun onProfileClicked() {
        screenNavigation.bringToFront(ScreenConfig.Profile)
    }

    private fun onHomeOutput(output: HomeComponent.Output): Unit = when (output) {

        else -> {}
    }

    private sealed interface ScreenConfig : Parcelable {
        @Parcelize
        data object Home : ScreenConfig

        @Parcelize
        data object Profile : ScreenConfig
    }
}