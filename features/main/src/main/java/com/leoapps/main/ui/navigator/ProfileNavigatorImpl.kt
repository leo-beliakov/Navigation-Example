package com.leoapps.main.ui.navigator

import com.leoapps.main.ui.model.MainNavCommand
import com.leoapps.profile.presentation.model.ProfileNavCommand
import com.leoapps.profile.presentation.navigation.ProfileNavigator

class ProfileNavigatorImpl(
    private val mainNavigator: MainNavigator,
) : ProfileNavigator {

    override fun onNavCommand(navCommand: ProfileNavCommand) {
        when (navCommand) {
            ProfileNavCommand.OpenAuth -> {
                mainNavigator.onNavCommand(MainNavCommand.OpenAuth)
            }
        }
    }
}