package com.leoapps.home.fourth.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeFourthNavCommand : NavigationCommand {
    object Back : HomeFourthNavCommand()
    object OpenFifthScreen : HomeFourthNavCommand()
}
