package com.leoapps.home.fifth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.fifth.presentation.model.HomeFifthUiState
import com.leoapps.home.fifth.presentation.navigation.HomeFifthNavigator
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
data class HomeFifthDestination(
    val listParam1: List<String>,
    val listParam2: List<EnumParam>,
    val listParam3: List<HomeCustomParam1>,
) : NavigationDestination

@Composable
fun HomeFifthScreen(
    viewModel: HomeFifthViewModel = hiltViewModel(),
    navigator: HomeFifthNavigator,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeFifthScreen(
        state = state,
        onBackClicked = viewModel::onBackClicked,
        onGoToFirstScreenClicked = viewModel::onGoToFirstScreenClicked,
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { command ->
        navigator.onNavCommand(command)
    }
}

@Composable
private fun HomeFifthScreen(
    state: HomeFifthUiState,
    onBackClicked: () -> Unit,
    onGoToFirstScreenClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = onBackClicked,
                modifier = Modifier.size(32.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Home Fifth Screen",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Spacer(
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = "(Showcases navigation to another feature)",
            color = Color(0xFFE65100),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
        )
        Text(
            "Received params: \n\nparam1 = ${state.listParam1}, \n\nparam2 = ${state.listParam2}, \n\nparam3 = ${state.listParam3}",
            color = Color(0xFF2E7D32),
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onGoToFirstScreenClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Third Screen")
        }
    }
}
