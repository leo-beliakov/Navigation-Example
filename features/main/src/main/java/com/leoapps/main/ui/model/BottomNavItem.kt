package com.leoapps.main.ui.model

import com.leoapps.chat.presentation.ChatDestination
import com.leoapps.home.root.presentation.HomeDestination
import com.leoapps.main.R
import com.leoapps.navigation.NavigationDestination
import com.leoapps.profile.presentation.ProfileDestination

enum class BottomNavItem(
    val title: String,
    val icon: Int,
    val destination: NavigationDestination
) {
    Home(
        "Home",
        R.drawable.ic_home,
        HomeDestination
    ),
    Chat(
        "Chat",
        R.drawable.ic_chat,
        ChatDestination
    ),
    Profile(
        "Profile",
        R.drawable.ic_profile,
        ProfileDestination
    )
}