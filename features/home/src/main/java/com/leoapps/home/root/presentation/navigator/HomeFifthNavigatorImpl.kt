package com.leoapps.home.root.presentation.navigator

import androidx.navigation.NavController
import com.leoapps.home.fifth.presentation.model.HomeFifthNavCommand
import com.leoapps.home.fifth.presentation.navigation.HomeFifthNavigator
import com.leoapps.home.first.presentation.HomeFirstDestination
import com.leoapps.home.root.presentation.model.HomeRootNavCommand

class HomeFifthNavigatorImpl(
    private val rootNavigator: HomeRootNavigator,
    private val navController: NavController
) : HomeFifthNavigator {

    override fun onNavCommand(navCommand: HomeFifthNavCommand) {
        when (navCommand) {
            HomeFifthNavCommand.Back -> {
                navController.navigateUp()
            }

            HomeFifthNavCommand.OpenFirst -> {
                navController.popBackStack(
                    route = HomeFirstDestination,
                    inclusive = false
                )
            }

            HomeFifthNavCommand.OpenChat -> {
                rootNavigator.onNavCommand(HomeRootNavCommand.OpenChat)
            }
        }
    }
}