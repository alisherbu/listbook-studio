package kaa.alisherbu.listbook.feature.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {

    val screenStack: Value<ChildStack<*, ChildScreen>>
    val dialogSlot: Value<ChildSlot<*, ChildDialog>>

    sealed interface ChildScreen {

        object Undefined : ChildScreen
    }

    sealed interface ChildDialog

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): RootComponent
    }
}
