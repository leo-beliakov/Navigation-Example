package com.leoapps.auth.login.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class LoginNavCommand : NavigationCommand {
    object OpenSignUp : LoginNavCommand()
    object OpenMain : LoginNavCommand()
}