package kaa.alisherbu.listbook.feature.root.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
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
import kaa.alisherbu.listbook.feature.root.component.RootComponent
import kaa.alisherbu.listbook.feature.root.component.RootComponent.ChildDialog
import kaa.alisherbu.listbook.feature.root.component.RootComponent.ChildScreen

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.screenStack,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            ChildScreen.Undefined -> ProgressIndicator()
        }
    }

    val dialogSlot by component.dialogSlot.subscribeAsState()
    dialogSlot.child?.instance?.also { childDialog ->

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
