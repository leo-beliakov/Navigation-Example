package com.leoapps.chat.first.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import kotlinx.serialization.Serializable

@Serializable
object ChatSecondDestination

@Composable
fun ChatSecondScreen(
    onDialogOpenClicked: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBDBDBD))
            .padding(16.dp),
    ) {
        Text(
            text = "Chat Screen",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onDialogOpenClicked,
        ) {
            Text("Open \"AlertDialog\" Dialog")
        }
        Button(
            onClick = onDialogOpenClicked,
        ) {
            Text("Open \"Dialog\" Dialog")
        }
        Button(
            onClick = onDialogOpenClicked,
        ) {
            Text("Open \"Dialog Destination\" Dialog")
        }
        Button(
            onClick = onDialogOpenClicked,
        ) {
            Text("Open Bottom Sheet Dialog")
        }
        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
}