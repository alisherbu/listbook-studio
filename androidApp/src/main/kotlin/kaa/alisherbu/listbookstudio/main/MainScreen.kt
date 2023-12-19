package kaa.alisherbu.listbookstudio.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kaa.alisherbu.listbookstudio.shared.main.MainComponent

@Composable
fun MainScreen(mainComponent: MainComponent) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Main", style = TextStyle(fontSize = 32.sp))
    }
}