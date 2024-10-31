package com.leoapps.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.leoapps.auth.presentation.LoginViewModel
import com.leoapps.auth.presentation.model.LoginUiState
import com.leoapps.auth.presentation.navigation.LoginNavigator
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import kotlinx.serialization.Serializable

@Serializable
object AuthDestination

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigator: LoginNavigator,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LoginScreen(
        state = state,
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { command ->
        navigator.onNavCommand(command)
    }
}

@Composable
private fun LoginScreen(
    state: LoginUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = "email",
            onValueChange = { },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "password",
            onValueChange = { },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Login")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        state = LoginUiState()
    )
}