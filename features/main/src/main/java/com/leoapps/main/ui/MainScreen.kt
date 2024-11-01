package com.leoapps.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.chat.presentation.ChatDestination
import com.leoapps.chat.presentation.ChatScreen
import com.leoapps.home.root.presentation.HomeDestination
import com.leoapps.home.root.presentation.HomeRootScreen
import com.leoapps.main.ui.composables.HomeNavBarItem
import com.leoapps.main.ui.model.BottomNavItem
import com.leoapps.main.ui.navigator.MainNavigator
import com.leoapps.main.ui.navigator.ProfileNavigatorImpl
import com.leoapps.navigation.openTab
import com.leoapps.profile.presentation.ProfileDestination
import com.leoapps.profile.presentation.ProfileScreen
import kotlinx.serialization.Serializable

@Serializable
object MainDestination

@Composable
fun MainScreen(
    navigator: MainNavigator
) {
    val items = BottomNavItem.entries
    val navController = rememberNavController()
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    // Update the selected item index when the destination changes
    // This is important to properly handle back navigation
    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            selectedItemIndex = items.indexOfFirst { bottomNavItem ->
                destination.hasRoute(bottomNavItem.destination::class)
            }
        }
    }

    MainScreen(
        items = items,
        selectedItemIndex = selectedItemIndex,
        navigator = navigator,
        navController = navController,
    )
}

@Composable
private fun MainScreen(
    items: List<BottomNavItem>,
    selectedItemIndex: Int,
    navigator: MainNavigator,
    navController: NavHostController,
) {
    Scaffold(
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HomeDestination,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<HomeDestination> {
                    HomeRootScreen()
                }
                composable<ChatDestination> {
                    ChatScreen()
                }
                composable<ProfileDestination> {
                    ProfileScreen(
                        navigator = ProfileNavigatorImpl(navigator)
                    )
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
                            navController.openTab(item.destination)
                        }
                    )
                }
            }
        }
    )
}
