package com.leoapps.home.second.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.second.presentation.model.HomeSecondNavCommand
import com.leoapps.home.second.presentation.navigation.HomeSecondNavigator
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object HomeSecondDestination : NavigationDestination

@Composable
fun HomeSecondScreen(
    navigator: HomeSecondNavigator,
) {
    var param1 by remember { mutableIntStateOf(0) }
    var param2 by remember { mutableStateOf("") }
    var param3 by remember { mutableStateOf(false) }
    var param4 by remember { mutableStateOf(EnumParam.VALUE1) }

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
                onClick = { navigator.onNavCommand(HomeSecondNavCommand.Back) },
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
            text = "(Showcases navigation with primitive-type arguments)",
            style = MaterialTheme.typography.bodyLarge,
            color = Color(0xFFE65100),
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Select Boolean param:")
            Checkbox(
                checked = param3,
                onCheckedChange = { param3 = it }
            )
        }
        DropdownParamMenu(param4) { selectedValue ->
            param4 = selectedValue
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = {
                navigator.onNavCommand(
                    HomeSecondNavCommand.OpenThirdScreen(
                        param1 = param1,
                        param2 = param2,
                        param3 = param3,
                        param4 = param4,
                    )
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Third Screen")
        }
    }
}

@Composable
private fun DropdownParamMenu(
    selectedValue: EnumParam,
    onValueChange: (EnumParam) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = "Select Enum Param:",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .background(MaterialTheme.colorScheme.surface)
                .border(1.dp, MaterialTheme.colorScheme.onSurface)
                .padding(16.dp)
        ) {
            Text(text = selectedValue.name)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            EnumParam.entries.forEach { value ->
                DropdownMenuItem(
                    text = { Text(value.name) },
                    onClick = {
                        onValueChange(value)
                        expanded = false
                    }
                )
            }
        }
    }
}