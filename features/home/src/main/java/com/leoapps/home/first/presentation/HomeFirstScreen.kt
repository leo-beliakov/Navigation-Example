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
import androidx.compose.ui.unit.dp
import com.leoapps.home.first.presentation.model.HomeFirstNavCommand
import com.leoapps.home.first.presentation.navigation.HomeFirstNavigator
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object HomeFirstDestination : NavigationDestination

@Composable
fun HomeFirstScreen(
    navigator: HomeFirstNavigator
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
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { navigator.onNavCommand(HomeFirstNavCommand.OpenSecondScreen) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Second Screen")
        }
    }
}
