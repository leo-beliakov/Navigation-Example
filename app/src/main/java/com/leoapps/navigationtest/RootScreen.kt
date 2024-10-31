package com.leoapps.navigationtest

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.auth.signup.presentation.SignupDestination
import com.leoapps.auth.signup.presentation.SignupScreen
import com.leoapps.feature_b.ui.OnboardingDestination
import com.leoapps.feature_b.ui.OnboardingScreen
import com.leoapps.main.ui.LoginDestination
import com.leoapps.main.ui.LoginScreen
import com.leoapps.main.ui.MainDestination
import com.leoapps.main.ui.MainScreen
import com.leoapps.navigationtest.presentation.navigation.LoginNavigatorImpl
import com.leoapps.navigationtest.presentation.navigation.MainNavigatorImpl
import com.leoapps.navigationtest.presentation.navigation.OnboardingNavigatorImpl
import com.leoapps.navigationtest.presentation.navigation.SignupNavigatorImpl
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
            MainScreen(
                navigator = MainNavigatorImpl(navController)
            )
        }
        composable<SignupDestination> {
            SignupScreen(
                navigator = SignupNavigatorImpl(navController)
            )
        }
        composable<LoginDestination> {
            LoginScreen(
                navigator = LoginNavigatorImpl(navController)
            )
        }
    }
}
