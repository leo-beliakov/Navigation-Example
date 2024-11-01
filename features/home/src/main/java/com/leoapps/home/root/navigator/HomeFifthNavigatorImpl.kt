package com.leoapps.home.root.navigator

import androidx.navigation.NavController
import com.leoapps.home.first.presentation.HomeFirstDestination
import com.leoapps.home.second.presentation.model.HomeFifthNavCommand
import com.leoapps.home.second.presentation.navigation.HomeFifthNavigator

class HomeFifthNavigatorImpl(
    private val navController: NavController
) : HomeFifthNavigator {

    override fun onNavCommand(navCommand: HomeFifthNavCommand) {
        when (navCommand) {
            HomeFifthNavCommand.Back -> {
                navController.popBackStack()
            }

            HomeFifthNavCommand.OpenFirst -> {
                navController.popBackStack(
                    route = HomeFirstDestination,
                    inclusive = false
                )
            }
        }
    }
}