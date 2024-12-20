package com.leoapps.home.fourth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import com.leoapps.common.ui.composables.ScreenToolbar
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.home.fourth.presentation.model.HomeFourthUiState
import com.leoapps.home.fourth.presentation.navigation.HomeFourthNavigator
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
data class HomeFourthDestination(
    val customParam1: HomeCustomParam1,
    val customParam2: HomeCustomParam2,
) : NavigationDestination

@Composable
fun HomeFourthScreen(
    viewModel: HomeFourthViewModel = hiltViewModel(),
    navigator: HomeFourthNavigator,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    HomeFourthScreen(
        state = state,
        onBackClicked = viewModel::onBackClicked,
        onGenerateParamsClicked = viewModel::onGenerateParamsClicked,
        onGoToFifthScreenClicked = viewModel::onGoToFifthScreenClicked,
    )

    CollectEventsWithLifecycle(viewModel.navigationCommands) { command ->
        navigator.onNavCommand(command)
    }
}

@Composable
private fun HomeFourthScreen(
    state: HomeFourthUiState,
    onBackClicked: () -> Unit,
    onGenerateParamsClicked: () -> Unit,
    onGoToFifthScreenClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenToolbar(
            title = "Home Fourth Screen",
            onBackClicked = onBackClicked,
        )
        Text(
            text = "(Showcases navigation with list-type arguments)",
            color = Color(0xFFE65100),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 12.dp)
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(1.dp)
                .background(Color.Gray)
        )
        Text(
            "Received params: \n\nparam1 = ${state.customParam1}, \n\nparam2 = ${state.customParam2}",
            color = Color(0xFF2E7D32),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(1.dp)
                .background(Color.Gray)
        )
        if (state.generatedParam1.isEmpty() && state.generatedParam2.isEmpty() && state.generatedParam3.isEmpty()) {
            Button(
                onClick = onGenerateParamsClicked,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Generate Params for Fifth Screen")
            }
        }
        if (state.generatedParam1.isNotEmpty()) {
            Text(
                text = "Generated Param1: \n${state.generatedParam1})",
                color = Color(0xFF1976D2),
                modifier = Modifier.fillMaxWidth()
            )
        }
        if (state.generatedParam2.isNotEmpty()) {
            Text(
                text = "Generated Param2: \n${state.generatedParam2})",
                color = Color(0xFF1976D2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
        if (state.generatedParam3.isNotEmpty()) {
            Text(
                text = "Generated Param3: \n${state.generatedParam3})",
                color = Color(0xFF1976D2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onGoToFifthScreenClicked,
            enabled = state.isNavigateNextEnabled,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Fifth Screen")
        }
    }
}