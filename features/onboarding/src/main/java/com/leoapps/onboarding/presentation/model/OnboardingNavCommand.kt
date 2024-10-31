package com.leoapps.onboarding.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class OnboardingNavCommand : NavigationCommand {
    object OpenAuth : OnboardingNavCommand()
}