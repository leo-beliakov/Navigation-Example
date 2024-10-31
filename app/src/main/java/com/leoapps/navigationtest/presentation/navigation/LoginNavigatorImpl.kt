package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.auth.login.presentation.model.LoginNavCommand
import com.leoapps.auth.login.presentation.navigation.LoginNavigator
import com.leoapps.auth.signup.presentation.SignupDestination
import com.leoapps.main.ui.MainDestination

class LoginNavigatorImpl(
    private val navController: NavController
) : LoginNavigator {

    override fun onNavCommand(navCommand: LoginNavCommand) {
        when (navCommand) {
            is LoginNavCommand.OpenSignUp -> {
                navController.navigate(SignupDestination)
            }

            is LoginNavCommand.OpenMain -> {
                navController.navigate(MainDestination)
            }
        }
    }
}