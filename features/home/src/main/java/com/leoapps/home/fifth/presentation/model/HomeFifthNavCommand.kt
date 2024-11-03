package com.leoapps.home.fifth.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeFifthNavCommand : NavigationCommand {
    object Back : HomeFifthNavCommand()
    object OpenFirst : HomeFifthNavCommand()
    object OpenChat : HomeFifthNavCommand()
}