package com.leoapps.home.first.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeFirstNavCommand : NavigationCommand {
    object OpenSecondScreen : HomeFirstNavCommand()
}