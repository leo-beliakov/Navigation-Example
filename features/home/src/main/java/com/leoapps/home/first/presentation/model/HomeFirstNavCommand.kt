package com.leoapps.home.second.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeFirstNavCommand : NavigationCommand {
    object OpenSecondScreen : HomeFirstNavCommand()
}