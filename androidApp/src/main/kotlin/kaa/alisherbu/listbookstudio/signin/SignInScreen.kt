package kaa.alisherbu.listbookstudio.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import kaa.alisherbu.listbookstudio.shared.signin.SignInComponent
import kaa.alisherbu.listbookstudio.shared.signin.store.SignInState

@Composable
fun SignInScreen(component: SignInComponent) {
    val state by component.state.subscribeAsState()
    Scaffold(
        topBar = {
            SignInTopAppBar(
                onBackClick = component::onBackClicked,
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        SignInContent(
            state = state,
            onEmailTextChange = component::onEmailTextChanged,
            onPasswordTextChange = component::onPasswordTextChanged,
            onLogInClick = component::onLogInClicked,
            modifier = Modifier.padding(it),
        )
    }
}

@Composable
private fun SignInContent(
    state: SignInState,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
    onLogInClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
        ) {
            SignInTextField(
                value = state.email,
                hintText = "Email",
                keyboardType = KeyboardType.Email,
                onValueChange = onEmailTextChange,
            )
            SignInTextField(
                value = state.password,
                hintText = "Password",
                keyboardType = KeyboardType.Password,
                onValueChange = onPasswordTextChange,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
        ) {
            Button(
                modifier = Modifier,
                onClick = onLogInClick,
                colors = buttonColors(
                    containerColor = Color.Black,
                ),
            ) {
                Text(
                    text = "Log in",
                    fontSize = 18.sp,
                )
            }
            Text(
                text = "or",
                color = Color.White,
                fontSize = 18.sp,
            )
            Row {
                IconButton(onClick = { }) {

                }
                IconButton(onClick = { }) {

                }
            }
        }
    }
}
