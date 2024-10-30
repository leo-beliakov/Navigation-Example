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
import com.leoapps.navigationtest.presentation.navigation.OnboardingNavigatorImpl
import com.leoapps.navigationtest.presentation.navigation.SplashNavigatorImpl
import com.leoapps.splash.presentation.SplashDestination
import com.leoapps.splash.presentation.SplashScreen

@Composable
fun RootScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashDestination
    ) {
        composable<SplashDestination> {
            SplashScreen(
                navigator = SplashNavigatorImpl(navController)
            )
        }
        composable<OnboardingDestination> {
            OnboardingScreen(
                navigator = OnboardingNavigatorImpl(navController)
            )
        }
        composable<MainDestination> {
            MainScreen()
        }
        composable<AuthDestination> {
            AuthScreen()
        }
    }
}
