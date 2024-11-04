package com.leoapps.chat.first.presentation

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import kotlinx.serialization.Serializable

@Serializable
object ChatSecondDialog

@Composable
fun ChatSecondDialog(
    onDismissRequest: () -> Unit,
    onNegativeClicked: () -> Unit,
    onPositiveClicked: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text("SomeTitle") },
        text = { Text("SomeSubTitle") },
        confirmButton = {
            TextButton(onClick = onPositiveClicked) {
                Text("Leave")
            }
        },
        dismissButton = {
            TextButton(onClick = onNegativeClicked) {
                Text("Stay")
            }
        },
        properties = DialogProperties(
            dismissOnClickOutside = true
        )
    )
}
