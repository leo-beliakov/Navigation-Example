package com.leoapps.navigation

import com.leoapps.mvi.model.NavigationCommand

/**
 * A base interface for handling navigation commands.
 *
 * @param NavCommand Type representing a navigation command for a specific feature.
 */
interface BaseNavigator<NavCommand : NavigationCommand> {

    /**
     * Called to execute a navigation command.
     */
    fun onNavCommand(navCommand: NavCommand)
}