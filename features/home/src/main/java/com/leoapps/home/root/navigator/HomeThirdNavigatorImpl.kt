package com.leoapps.home.root.navigator

import androidx.navigation.NavController
import com.leoapps.home.fourth.presentation.HomeFourthDestination
import com.leoapps.home.third.presentation.model.HomeThirdNavCommand
import com.leoapps.home.third.presentation.navigation.HomeThirdNavigator

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