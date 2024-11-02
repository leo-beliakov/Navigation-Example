package com.leoapps.home.root.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.EnumParamListNavType
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam1ListNavType
import com.leoapps.home.base.domain.model.HomeCustomParam1NavType
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.home.base.domain.model.HomeCustomParam2NavType
import com.leoapps.home.fifth.presentation.HomeFifthDestination
import com.leoapps.home.fifth.presentation.HomeFifthScreen
import com.leoapps.home.first.presentation.HomeFirstDestination
import com.leoapps.home.first.presentation.HomeFirstScreen
import com.leoapps.home.fourth.presentation.HomeFourthDestination
import com.leoapps.home.fourth.presentation.HomeFourthScreen
import com.leoapps.home.root.navigator.HomeFifthNavigatorImpl
import com.leoapps.home.root.navigator.HomeFirstNavigatorImpl
import com.leoapps.home.root.navigator.HomeFourthNavigatorImpl
import com.leoapps.home.root.navigator.HomeSecondNavigatorImpl
import com.leoapps.home.root.navigator.HomeThirdNavigatorImpl
import com.leoapps.home.second.presentation.HomeSecondDestination
import com.leoapps.home.second.presentation.HomeSecondScreen
import com.leoapps.home.third.presentation.HomeThirdDestination
import com.leoapps.home.third.presentation.HomeThirdScreen
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

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
                navigator = HomeFirstNavigatorImpl(navController)
            )
        }
        composable<HomeSecondDestination> {
            HomeSecondScreen(
                navigator = HomeSecondNavigatorImpl(navController)
            )
        }
        composable<HomeThirdDestination> {
            HomeThirdScreen(
                navigator = HomeThirdNavigatorImpl(navController),
            )
        }
        composable<HomeFourthDestination>(
            typeMap = mapOf(
                typeOf<HomeCustomParam1>() to HomeCustomParam1NavType,
                typeOf<HomeCustomParam2>() to HomeCustomParam2NavType,
            )
        ) {
            HomeFourthScreen(
                navigator = HomeFourthNavigatorImpl(navController)
            )
        }
        composable<HomeFifthDestination>(
            typeMap = mapOf(
                typeOf<List<EnumParam>>() to EnumParamListNavType,
                typeOf<List<HomeCustomParam1>>() to HomeCustomParam1ListNavType
            )
        ) {
            HomeFifthScreen(
                navigator = HomeFifthNavigatorImpl(navController)
            )
        }
    }
}