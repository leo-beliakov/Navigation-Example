package com.leoapps.profile.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class ProfileNavCommand : NavigationCommand {
    object OpenAuth : ProfileNavCommand()
}