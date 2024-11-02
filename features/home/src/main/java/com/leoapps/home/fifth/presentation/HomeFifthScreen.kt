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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.fifth.presentation.model.HomeFifthNavCommand
import com.leoapps.home.fifth.presentation.navigation.HomeFifthNavigator
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
                onClick = { navigator.onNavCommand(HomeFifthNavCommand.Back) },
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
        TextField(
            value = param1.toString(),
            onValueChange = { param1 = it.toIntOrNull() ?: 0 },
            label = { Text("Enter primitive param (Int)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
        TextField(
            value = param2,
            onValueChange = { param2 = it },
            label = { Text("Enter primitive param (String)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { navigator.onNavCommand(HomeFifthNavCommand.OpenFirst) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Third Screen")
        }
    }
}
