package com.leoapps.home.root.navigator

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
                navController.popBackStack()
            }

            HomeSecondNavCommand.OpenThirdScreen -> {
                navController.navigate(HomeThirdDestination)
            }
        }
    }
}