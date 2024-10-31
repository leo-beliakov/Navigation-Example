package com.leoapps.auth.signup.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoapps.auth.signup.presentation.model.SignupUiState
import com.leoapps.auth.signup.presentation.navigation.SignupNavigator
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import kotlinx.serialization.Serializable

@Serializable
object SignupDestination

@Composable
fun SignupScreen(
    viewModel: SignupViewModel = hiltViewModel(),
    navigator: SignupNavigator
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SignupScreen(
        state = state,
        onNameChanged = viewModel::onNameChanged,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onConfirmPasswordChanged = viewModel::onConfirmPasswordChanged,
        onSignupClicked = viewModel::onSignupClicked,
        onLoginClicked = viewModel::onLoginClicked,
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { navCommand ->
        navigator.onNavCommand(navCommand)
    }
}

@Composable
private fun SignupScreen(
    state: SignupUiState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onConfirmPasswordChanged: (String) -> Unit,
    onSignupClicked: () -> Unit,
    onLoginClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = state.name,
            enabled = !state.isLoading,
            onValueChange = onNameChanged,
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.email,
            enabled = !state.isLoading,
            onValueChange = onEmailChanged,
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = state.password,
            enabled = !state.isLoading,
            onValueChange = onPasswordChanged,
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        OutlinedTextField(
            value = state.confirmPassword,
            enabled = !state.isLoading,
            onValueChange = onConfirmPasswordChanged,
            label = { Text("Confirm Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = onSignupClicked,
            enabled = state.isSignupEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp,
                    modifier = Modifier.size(20.dp)
                )
            } else {
                Text("Sign Up")
            }
        }
        Text(
            text = "Already have an account? Log in",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable(
                    onClick = onLoginClicked,
                    enabled = !state.isLoading,
                )
        )
    }
}

@Preview(name = "Signup Empty State")
@Composable
private fun SignupScreenEmptyPreview() {
    SignupScreen(
        state = SignupUiState(),
        onNameChanged = { },
        onEmailChanged = { },
        onPasswordChanged = { },
        onConfirmPasswordChanged = { },
        onSignupClicked = { },
        onLoginClicked = { },
    )
}

@Preview(name = "Signup Filled-in State")
@Composable
private fun SignupScreenPreview() {
    SignupScreen(
        state = SignupUiState(
            email = "someEmail@gmail.com",
            name = "John Doe",
            password = "password",
            confirmPassword = "password",
            isSignupEnabled = true
        ),
        onNameChanged = { },
        onEmailChanged = { },
        onPasswordChanged = { },
        onConfirmPasswordChanged = { },
        onSignupClicked = { },
        onLoginClicked = { },
    )
}