package com.leoapps.navigationtest.presentation.navigation

import androidx.navigation.NavController
import com.leoapps.main.ui.AuthDestination
import com.leoapps.main.ui.model.MainNavCommand
import com.leoapps.main.ui.navigator.MainNavigator

class MainNavigatorImpl(
    private val navController: NavController,
) : MainNavigator {

    override fun onNavCommand(navCommand: MainNavCommand) {
        when (navCommand) {
            MainNavCommand.OpenAuth -> {
                navController.navigate(AuthDestination)
            }
        }
    }
}