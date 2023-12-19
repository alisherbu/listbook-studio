package kaa.alisherbu.listbookstudio.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import kaa.alisherbu.listbookstudio.shared.auth.AuthComponent

@Composable
fun AuthScreen(component: AuthComponent) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = component::onSignupClicked,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        ) {
            Text(
                text = "Create account",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(0.5f),
                textAlign = TextAlign.Center,
            )
        }

        Button(
            onClick = {
                component.onSignInClicked()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        ) {
            Text(
                text = "Sign in",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(0.5f),
                textAlign = TextAlign.Center,
            )
        }
    }
}
