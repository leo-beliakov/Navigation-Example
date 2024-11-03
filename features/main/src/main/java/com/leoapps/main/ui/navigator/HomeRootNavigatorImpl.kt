package com.leoapps.main.ui.navigator

import androidx.navigation.NavController
import com.leoapps.chat.presentation.ChatDestination
import com.leoapps.home.root.presentation.model.HomeRootNavCommand
import com.leoapps.home.root.presentation.navigator.HomeRootNavigator

class HomeRootNavigatorImpl(
    private val navController: NavController
) : HomeRootNavigator {

    override fun onNavCommand(navCommand: HomeRootNavCommand) {
        when (navCommand) {
            HomeRootNavCommand.OpenChat -> {
                navController.navigate(ChatDestination)
            }
        }
    }
}
