package com.leoapps.chat.first.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leoapps.common.ui.composables.ScreenToolbar
import kotlinx.serialization.Serializable

@Serializable
object ChatSecondDestination

@Composable
fun ChatSecondScreen(
    onBackClicked: () -> Unit,
    onDialogOpenClicked: () -> Unit,
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBDBDBD))
            .padding(16.dp),
    ) {
        ScreenToolbar(
            title = "Chat Second Screen",
            onBackClicked = onBackClicked,
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = { showDialog = true },
        ) {
            Text("Open Embeded Dialog")
        }
        Button(
            onClick = onDialogOpenClicked,
        ) {
            Text("Open Destination Dialog")
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
    }

    if (showDialog) {
        ChatSecondDialog(
            onDismissRequest = { showDialog = false },
            onNegativeClicked = { showDialog = false },
            onPositiveClicked = {
                showDialog = false //this line is important for correct visual behavior
                onBackClicked()
            }
        )
    }
}