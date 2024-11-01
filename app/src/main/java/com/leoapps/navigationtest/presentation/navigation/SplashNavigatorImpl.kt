package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.feature_b.ui.OnboardingDestination
import com.leoapps.main.ui.LoginDestination
import com.leoapps.main.ui.MainDestination
import com.leoapps.splash.presentation.SplashDestination
import com.leoapps.splash.presentation.model.SplashNavCommand
import com.leoapps.splash.presentation.navigation.SplashNavigator

class SplashNavigatorImpl(
    private val navController: NavController,
) : SplashNavigator {

    override fun onNavCommand(navCommand: SplashNavCommand) {
        when (navCommand) {
            is SplashNavCommand.OpenMain -> openMain()
            is SplashNavCommand.OpenOnboarding -> openOnboarding()
            SplashNavCommand.OpenAuth -> openAuth()
        }
    }

    private fun openMain() {
        navController.navigate(MainDestination) {
            popUpTo(SplashDestination) {
                inclusive = true
            }
        }
    }

    private fun openOnboarding() {
        navController.navigate(OnboardingDestination) {
            popUpTo(SplashDestination) {
                inclusive = true
            }
        }
    }

    private fun openAuth() {
        navController.navigate(LoginDestination) {
            popUpTo(SplashDestination) {
                inclusive = true
            }
        }
    }
}