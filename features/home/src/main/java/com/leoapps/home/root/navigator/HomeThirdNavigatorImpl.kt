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
                navController.navigateUp()
            }

            is HomeThirdNavCommand.OpenFourthScreen -> {
                navController.navigate(
                    HomeFourthDestination(
                        customParam1 = navCommand.customParam1,
                        customParam2 = navCommand.customParam2,
                    )
                )
            }
        }
    }
}