package kaa.alisherbu.listbookstudio.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kaa.alisherbu.listbookstudio.shared.profile.ProfileComponent

@Composable
fun ProfileScreen(component: ProfileComponent) {
    Scaffold(
        topBar = {
            ProfileTopAppBar()
        },
    ) {
        ProfileContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun ProfileContent(modifier: Modifier = Modifier) {

}