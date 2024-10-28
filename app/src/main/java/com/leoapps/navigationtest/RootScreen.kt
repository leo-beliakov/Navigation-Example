package com.leoapps.navigationtest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.feature_b.ui.OnboardingDestination
import com.leoapps.feature_b.ui.OnboardingScreen
import com.leoapps.main.ui.AuthDestination
import com.leoapps.main.ui.AuthScreen
import com.leoapps.main.ui.MainDestination
import com.leoapps.main.ui.MainScreen
import com.leoapps.splash.ui.SplashDestination
import com.leoapps.splash.ui.SplashScreen

@Composable
fun RootScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainDestination
    ) {
        composable<SplashDestination> {
            SplashScreen()
        }
        composable<OnboardingDestination> {
            OnboardingScreen()
        }
        composable<MainDestination> {
            MainScreen()
        }
        composable<AuthDestination> {
            AuthScreen()
        }
    }
}
