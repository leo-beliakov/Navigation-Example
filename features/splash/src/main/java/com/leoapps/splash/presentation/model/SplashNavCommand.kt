package com.leoapps.splash.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class SplashNavCommand : NavigationCommand {
    object OpenMain : SplashNavCommand()
    object OpenAuth : SplashNavCommand()
    object OpenOnboarding : SplashNavCommand()
}