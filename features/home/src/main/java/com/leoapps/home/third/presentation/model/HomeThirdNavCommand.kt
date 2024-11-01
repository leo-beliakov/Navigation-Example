package com.leoapps.home.second.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeThirdNavCommand : NavigationCommand {
    object Back : HomeThirdNavCommand()
    object OpenFourthScreen : HomeThirdNavCommand()
}