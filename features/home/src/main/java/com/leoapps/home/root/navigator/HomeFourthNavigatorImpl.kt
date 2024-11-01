package com.leoapps.home.root.navigator

import androidx.navigation.NavController
import com.leoapps.home.fifth.presentation.HomeFifthDestination
import com.leoapps.home.fourth.presentation.model.HomeFourthNavCommand
import com.leoapps.home.fourth.presentation.navigation.HomeFourthNavigator

class HomeFourthNavigatorImpl(
    private val navController: NavController
) : HomeFourthNavigator {

    override fun onNavCommand(navCommand: HomeFourthNavCommand) {
        when (navCommand) {
            HomeFourthNavCommand.Back -> {
                navController.popBackStack()
            }

            HomeFourthNavCommand.OpenFifthScreen -> {
                navController.navigate(HomeFifthDestination)
            }
        }
    }
}