package com.leoapps.main.ui.model

import com.leoapps.chat.presentation.ChatDestination
import com.leoapps.home.presentation.HomeDestination
import com.leoapps.main.R
import com.leoapps.navigation.NavigationDestination
import com.leoapps.profile.presentation.ProfileDestination

sealed class BottomNavItem(
    val title: String,
    val icon: Int,
    val destination: NavigationDestination
) {
    object Home : BottomNavItem(
        "Home",
        R.drawable.ic_home,
        HomeDestination
    )

    object Chat : BottomNavItem(
        "Chat",
        R.drawable.ic_chat,
        ChatDestination
    )

    object Profile : BottomNavItem(
        "Profile",
        R.drawable.ic_profile,
        ProfileDestination
    )
}