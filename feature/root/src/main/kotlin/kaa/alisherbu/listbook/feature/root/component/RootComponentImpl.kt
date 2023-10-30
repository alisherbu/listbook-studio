package kaa.alisherbu.listbook.feature.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kaa.alisherbu.listbook.core.shared.coroutine.AppDispatchers
import kaa.alisherbu.listbook.core.shared.model.AudioBook
import kaa.alisherbu.listbook.feature.root.component.RootComponent.ChildDialog
import kaa.alisherbu.listbook.feature.root.component.RootComponent.ChildScreen
import kaa.alisherbu.listbook.feature.root.store.Label
import kaa.alisherbu.listbook.feature.root.store.RootStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize
import javax.inject.Provider
import kotlin.time.Duration.Companion.milliseconds

class RootComponentImpl @AssistedInject internal constructor(
    @Assisted componentContext: ComponentContext,
    private val storeProvider: Provider<RootStore>,
    dispatchers: AppDispatchers,
) : RootComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore(storeProvider::get)
    private val mainScope = CoroutineScope(dispatchers.main)
    private val screenNavigation = StackNavigation<ScreenConfig>()
    private val dialogNavigation = SlotNavigation<DialogConfig>()

    init {
        store.labels
            .onEach(::handleLabel)
            .launchIn(mainScope)
        mainScope.launch {
            delay(INIT_DELAY)
            store.init()
        }
        lifecycle.doOnDestroy(mainScope::cancel)
    }

    override val screenStack: Value<ChildStack<*, ChildScreen>> = childStack(
        source = screenNavigation,
        initialConfiguration = ScreenConfig.Undefined,
        handleBackButton = true,
        childFactory = ::createChildScreen,
    )

    override val dialogSlot: Value<ChildSlot<*, ChildDialog>> = childSlot(
        source = dialogNavigation,
        handleBackButton = true,
        childFactory = ::createChildDialog,
    )

    private fun handleLabel(label: Label) {

    }

    private fun createChildScreen(
        config: ScreenConfig,
        componentContext: ComponentContext,
    ): ChildScreen = when (config) {
        ScreenConfig.Undefined -> {
            ChildScreen.Undefined
        }
    }

    private fun createChildDialog(
        config: DialogConfig,
        componentContext: ComponentContext,
    ): ChildDialog = when (config) {
        is DialogConfig.Message -> {
            error("")
        }
    }

    private sealed interface ScreenConfig : Parcelable {

        @Parcelize
        data object Undefined : ScreenConfig

    }

    private sealed interface DialogConfig : Parcelable {
        @Parcelize
        class Message(
            val text: String,
        ) : DialogConfig
    }

    @AssistedFactory
    interface Factory : RootComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
        ): RootComponentImpl
    }

    companion object {
        private val INIT_DELAY = 1.milliseconds
    }
}
