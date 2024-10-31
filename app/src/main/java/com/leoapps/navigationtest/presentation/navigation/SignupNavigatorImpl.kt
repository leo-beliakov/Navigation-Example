package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.auth.signup.presentation.model.SignupNavCommand
import com.leoapps.auth.signup.presentation.navigation.SignupNavigator
import com.leoapps.main.ui.LoginDestination
import com.leoapps.main.ui.MainDestination

class SignupNavigatorImpl(
    private val navController: NavController
) : SignupNavigator {

    override fun onNavCommand(navCommand: SignupNavCommand) {
        when (navCommand) {
            is SignupNavCommand.OpenLogin -> {
                navController.popBackStack<LoginDestination>(inclusive = false)
            }

            is SignupNavCommand.OpenMain -> {
                navController.navigate(MainDestination) {
                    popUpTo(LoginDestination) {
                        inclusive = true
                    }
                }
            }
        }
    }
}