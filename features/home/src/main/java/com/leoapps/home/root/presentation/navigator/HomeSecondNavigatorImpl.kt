package com.leoapps.home.root.presentation.navigator

import androidx.navigation.NavController
import com.leoapps.home.second.presentation.model.HomeSecondNavCommand
import com.leoapps.home.second.presentation.navigation.HomeSecondNavigator
import com.leoapps.home.third.presentation.HomeThirdDestination

class HomeSecondNavigatorImpl(
    private val navController: NavController
) : HomeSecondNavigator {

    override fun onNavCommand(navCommand: HomeSecondNavCommand) {
        when (navCommand) {
            HomeSecondNavCommand.Back -> {
                navController.navigateUp()
            }

            is HomeSecondNavCommand.OpenThirdScreen -> {
                navController.navigate(
                    HomeThirdDestination(
                        param1 = navCommand.param1,
                        param2 = navCommand.param2,
                        param3 = navCommand.param3,
                        param4 = navCommand.param4,
                    )
                )
            }
        }
    }
}