package com.leoapps.home.third.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.leoapps.home.third.presentation.model.HomeThirdNavCommand
import com.leoapps.home.third.presentation.navigation.HomeThirdNavigator
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
data class HomeThirdDestination(
    val param1: Int,
    val param2: String,
    val param3: Boolean,
    val param4: Param4
) : NavigationDestination {

    enum class Param4 {
        VALUE1,
        VALUE2,
        VALUE3
    }
}

@Composable
fun HomeThirdScreen(
    input: HomeThirdDestination,
    navigator: HomeThirdNavigator,
) {
    var param1 by remember { mutableIntStateOf(0) }
    var param2 by remember { mutableStateOf("") }

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
                onClick = { navigator.onNavCommand(HomeThirdNavCommand.Back) },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Home Second Screen",
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            Spacer(
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            "Received params: \nparam1 = ${input.param1}, \nparam2 = ${input.param2}, \nparam3 = ${input.param3}, \nparam4 = ${input.param4}",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Button(
            onClick = { navigator.onNavCommand(HomeThirdNavCommand.OpenFourthScreen) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Fourth Screen")
        }
    }
}
