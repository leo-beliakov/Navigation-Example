package com.leoapps.chat.dialog.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
object ChatDialogDestination

@Composable
fun ChatDialog(

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    )
}