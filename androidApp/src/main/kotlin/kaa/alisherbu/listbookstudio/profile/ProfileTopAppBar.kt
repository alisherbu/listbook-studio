package kaa.alisherbu.listbookstudio.profile

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(text = "Profile")
    })
}
