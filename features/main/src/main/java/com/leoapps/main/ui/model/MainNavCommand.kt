package com.leoapps.main.ui.model

import com.leoapps.mvi.model.NavigationCommand

sealed class MainNavCommand : NavigationCommand {
    object OpenAuth : MainNavCommand()
}