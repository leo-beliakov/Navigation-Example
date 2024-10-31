package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.auth.presentation.model.LoginNavCommand
import com.leoapps.auth.presentation.navigation.LoginNavigator
import com.leoapps.main.ui.MainDestination

class LoginNavigatorImpl(
    private val navController: NavController
) : LoginNavigator {

    override fun onNavCommand(navCommand: LoginNavCommand) {
        when (navCommand) {
            is LoginNavCommand.OpenSignUp -> {

            }

            is LoginNavCommand.OpenMain -> {
                navController.navigate(MainDestination)
            }
        }
    }
}