package com.leoapps.profile.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.navigation.NavigationDestination
import com.leoapps.profile.presentation.model.ProfileUiState
import com.leoapps.profile.presentation.navigation.ProfileNavigator
import kotlinx.serialization.Serializable

@Serializable
object ProfileDestination : NavigationDestination

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigator: ProfileNavigator,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ProfileScreen(
        state = state,
        onLogoutClicked = viewModel::onLogoutClicked,
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { navCommand ->
        navigator.onNavCommand(navCommand)
    }
}

@Composable
private fun ProfileScreen(
    state: ProfileUiState,
    onLogoutClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFCFD8DC))
            .padding(32.dp)
    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Username: ${state.username}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Email: ${state.email}",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(top = 6.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onLogoutClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Log out")
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(
        state = ProfileUiState(
            username = "Leo",
            email = "efesdfve@esvfd.sfv"
        ),
        onLogoutClicked = { }
    )
}