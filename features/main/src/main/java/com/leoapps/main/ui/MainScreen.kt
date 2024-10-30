package com.leoapps.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.chat.presentation.ChatDestination
import com.leoapps.chat.presentation.ChatScreen
import com.leoapps.home.presentation.HomeDestination
import com.leoapps.home.presentation.HomeScreen
import com.leoapps.main.ui.composables.HomeNavBarItem
import com.leoapps.main.ui.model.BottomNavItem
import com.leoapps.main.ui.navigator.ProfileNavigatorImpl
import com.leoapps.navigation.openTab
import com.leoapps.profile.presentation.ProfileDestination
import com.leoapps.profile.presentation.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object MainDestination

@Composable
fun MainScreen(
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Chat,
        BottomNavItem.Profile
    )

    val navController = rememberNavController()
    var selectedItemIndex by remember { mutableStateOf(0) }

    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HomeDestination,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<HomeDestination> {
                    HomeScreen()
                }
                composable<ProfileDestination> {
                    ProfileScreen(navigator = ProfileNavigatorImpl())
                }
                composable<ChatDestination> {
                    ChatScreen()
                }
            }
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    HomeNavBarItem(
                        item = item,
                        isSelected = selectedItemIndex == index,
                        onTabClick = {
                            selectedItemIndex = items.indexOf(item)
                            navController.openTab(item.destination)
                        }
                    )
                }
            }
        }
    )
}