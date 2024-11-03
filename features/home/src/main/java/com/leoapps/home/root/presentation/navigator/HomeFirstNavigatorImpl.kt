package com.leoapps.home.root.presentation.navigator

import androidx.navigation.NavController
import com.leoapps.home.first.presentation.model.HomeFirstNavCommand
import com.leoapps.home.first.presentation.navigation.HomeFirstNavigator
import com.leoapps.home.second.presentation.HomeSecondDestination

class HomeFirstNavigatorImpl(
    private val navController: NavController
) : HomeFirstNavigator {

    override fun onNavCommand(navCommand: HomeFirstNavCommand) {
        when (navCommand) {
            HomeFirstNavCommand.OpenSecondScreen -> navController.navigate(HomeSecondDestination)
        }
    }
}