package com.leoapps.home.root.navigator

import androidx.navigation.NavController
import com.leoapps.home.second.presentation.HomeSecondDestination
import com.leoapps.home.second.presentation.model.HomeFirstNavCommand
import com.leoapps.home.second.presentation.navigation.HomeFirstNavigator

class HomeFirstNavigatorImpl(
    private val navController: NavController
) : HomeFirstNavigator {

    override fun onNavCommand(navCommand: HomeFirstNavCommand) {
        when (navCommand) {
            HomeFirstNavCommand.OpenSecondScreen -> navController.navigate(HomeSecondDestination)
        }
    }
}