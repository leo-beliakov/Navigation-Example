package com.leoapps.auth.signup.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class SignupNavCommand : NavigationCommand {
    object OpenLogin : SignupNavCommand()
    object OpenMain : SignupNavCommand()
}