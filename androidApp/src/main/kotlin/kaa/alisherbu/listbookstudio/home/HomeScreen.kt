package kaa.alisherbu.listbookstudio.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kaa.alisherbu.listbookstudio.shared.home.HomeComponent

@Composable
fun HomeScreen(component: HomeComponent) {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        HomeContent(
            modifier = Modifier.padding(it),
        )
    }
}

@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
) {

}
