package com.leoapps.main.ui.navigator

import androidx.navigation.NavController
import com.leoapps.chat.dialog.presentation.ChatDialogDestination
import com.leoapps.chat.root.presentation.model.ChatNavCommand
import com.leoapps.chat.root.presentation.navigation.ChatNavigator

class ChatNavigatorImpl(
    private val navController: NavController,
) : ChatNavigator {

    override fun onNavCommand(navCommand: ChatNavCommand) {
        when (navCommand) {
            ChatNavCommand.OpenDialog -> {
                navController.navigate(ChatDialogDestination)
            }
        }
    }
}