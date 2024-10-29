package com.leoapps.splash.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.splash.presentation.navigation.SplashNavigator
import kotlinx.serialization.Serializable

@Serializable
object SplashDestination

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navigator: SplashNavigator,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(text = "Splash Screen")
    }

    CollectEventsWithLifecycle(viewModel.navigationCommands) { navCommand ->
        navigator.onNavCommand(navCommand)
    }
}