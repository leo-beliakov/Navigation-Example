package com.leoapps.home.root.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class HomeRootNavCommand : NavigationCommand {
    object OpenChat : HomeRootNavCommand()
}