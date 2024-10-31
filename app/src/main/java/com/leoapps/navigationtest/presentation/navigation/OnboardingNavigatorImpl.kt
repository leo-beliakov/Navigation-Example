package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.main.ui.LoginDestination
import com.leoapps.onboarding.presentation.model.OnboardingNavCommand
import com.leoapps.onboarding.presentation.navigator.OnboardingNavigator

class OnboardingNavigatorImpl(
    private val navController: NavController,
) : OnboardingNavigator {

    override fun onNavCommand(navCommand: OnboardingNavCommand) {
        when (navCommand) {
            OnboardingNavCommand.OpenAuth -> navController.navigate(LoginDestination)
        }
    }
}