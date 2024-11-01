package com.leoapps.home.third.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeThirdNavCommand : NavigationCommand {
    object Back : HomeThirdNavCommand()
    object OpenFourthScreen : HomeThirdNavCommand()
}