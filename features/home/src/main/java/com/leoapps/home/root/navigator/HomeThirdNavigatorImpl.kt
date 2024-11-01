package com.leoapps.home.root.navigator

import androidx.navigation.NavController
import com.leoapps.home.second.presentation.HomeFourthDestination
import com.leoapps.home.second.presentation.model.HomeThirdNavCommand
import com.leoapps.home.second.presentation.navigation.HomeThirdNavigator

class HomeThirdNavigatorImpl(
    private val navController: NavController
) : HomeThirdNavigator {

    override fun onNavCommand(navCommand: HomeThirdNavCommand) {
        when (navCommand) {
            HomeThirdNavCommand.Back -> {
                navController.popBackStack()
            }

            HomeThirdNavCommand.OpenFourthScreen -> {
                navController.navigate(HomeFourthDestination)
            }
        }
    }
}