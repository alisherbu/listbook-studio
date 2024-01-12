package kaa.alisherbu.listbookstudio.signup

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
import kaa.alisherbu.listbookstudio.shared.signup.SignupComponent
import kaa.alisherbu.listbookstudio.shared.signup.store.SignupState

@Composable
fun SignupScreen(component: SignupComponent) {
    val state by component.state.subscribeAsState()
    Scaffold(
        topBar = {
            SignupTopAppBar(
                onBackClick = component::onBackClicked,
            )
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) {
        SignupContent(
            state = state,
            onNameTextChange = component::onNameTextChanged,
            onSurnameTextChange = component::onSurnameTextChanged,
            onEmailTextChange = component::onEmailTextChanged,
            onPasswordTextChange = component::onPasswordTextChanged,
            onCreateAccountClick = component::onCreateAccountClicked,
            modifier = Modifier.padding(it),
        )
    }
}

@Composable
@Suppress("LongParameterList")
private fun SignupContent(
    state: SignupState,
    onNameTextChange: (String) -> Unit,
    onSurnameTextChange: (String) -> Unit,
    onEmailTextChange: (String) -> Unit,
    onPasswordTextChange: (String) -> Unit,
    onCreateAccountClick: () -> Unit,
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
            SignupTextField(
                value = state.name,
                hintText = "Name",
                onValueChange = onNameTextChange,
            )
            SignupTextField(
                value = state.surname,
                hintText = "Surname",
                onValueChange = onSurnameTextChange,
            )
            SignupTextField(
                value = state.email,
                hintText = "Email",
                keyboardType = KeyboardType.Email,
                onValueChange = onEmailTextChange,
            )
            SignupTextField(
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
                onClick = onCreateAccountClick,
                colors = buttonColors(
                    containerColor = Color.Black,
                ),
                enabled = state.isCreateAccountButtonEnabled,
            ) {
                Text(
                    text = "Create account",
                    fontSize = 18.sp,
                    color = Color.White,
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
