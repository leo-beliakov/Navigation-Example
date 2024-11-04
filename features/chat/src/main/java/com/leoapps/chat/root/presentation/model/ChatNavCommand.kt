package com.leoapps.chat.root.presentation.model

import com.leoapps.mvi.model.NavigationCommand

sealed class ChatNavCommand : NavigationCommand {
    object OpenDialog : ChatNavCommand()
}