package kaa.alisherbu.listbookstudio.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack
import kaa.alisherbu.listbookstudio.home.HomeScreen
import kaa.alisherbu.listbookstudio.profile.ProfileScreen
import kaa.alisherbu.listbookstudio.shared.main.MainComponent
import kaa.alisherbu.listbookstudio.shared.main.MainComponent.ChildScreen

@Composable
fun MainScreen(component: MainComponent) {
    val screenStack by component.screenStack.subscribeAsState()
    val activeComponent = screenStack.active.instance
    Scaffold(bottomBar = {
        BottomNavigation(
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomNavigationItem(
                selected = activeComponent is ChildScreen.Home,
                onClick = component::onHomeClicked,
                icon = {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
                },
                label = {
                    Text(text = "Home")
                },
            )
            BottomNavigationItem(
                selected = activeComponent is ChildScreen.Profile,
                onClick = component::onProfileClicked,
                icon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
                },
                label = {
                    Text(text = "Profile")
                },
            )
        }
    }, content = {
        MainContent(screenStack = screenStack, modifier = Modifier.padding(it))
    })
}

@Composable
private fun MainContent(
    screenStack: ChildStack<*, ChildScreen>, modifier: Modifier = Modifier
) {
    Children(stack = screenStack, modifier = modifier) {
        when (val child = it.instance) {
            is ChildScreen.Home -> HomeScreen(child.component)
            is ChildScreen.Profile -> ProfileScreen(child.component)
        }
    }
}