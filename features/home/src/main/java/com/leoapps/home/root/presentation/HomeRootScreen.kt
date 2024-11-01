package com.leoapps.home.root.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.home.first.presentation.HomeFirstDestination
import com.leoapps.home.first.presentation.HomeFirstScreen
import com.leoapps.home.second.presentation.HomeSecondDestination
import com.leoapps.home.second.presentation.HomeSecondScreen
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination : NavigationDestination

@Composable
fun HomeRootScreen() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeFirstDestination
    ) {
        composable<HomeFirstDestination> {
            HomeFirstScreen(
                onNavigateToSecondScreen = {
                    navController.navigate(HomeSecondDestination)
                }
            )
        }
        composable<HomeSecondDestination> {
            HomeSecondScreen(
                onNavigateToThirdScreen = {
//                    navController.navigate(HomeDestination)
                }
            )
        }
    }
}