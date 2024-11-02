package com.leoapps.home.first.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoapps.home.first.presentation.navigation.HomeFirstNavigator
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object HomeFirstDestination : NavigationDestination

@Composable
fun HomeFirstScreen(
    viewModel: HomeFirstViewModel = hiltViewModel(),
    navigator: HomeFirstNavigator
) {
    HomeFirstScreen(
        onGoToSecondScreenClicked = viewModel::onGoToSecondScreenClicked
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { command ->
        navigator.onNavCommand(command)
    }
}

@Composable
private fun HomeFirstScreen(
    onGoToSecondScreenClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home First Screen",
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = "(Showcases navigation without arguments)",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = Color(0xFFE65100),
            modifier = Modifier.padding(top = 12.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onGoToSecondScreenClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Second Screen")
        }
    }
}
