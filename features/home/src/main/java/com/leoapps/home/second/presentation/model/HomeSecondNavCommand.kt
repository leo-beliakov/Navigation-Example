package com.leoapps.home.second.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeSecondNavCommand : NavigationCommand {
    object Back : HomeSecondNavCommand()
    object OpenThirdScreen : HomeSecondNavCommand()
}