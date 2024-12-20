package com.leoapps.chat.root.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.leoapps.chat.first.presentation.ChatFirstDestination
import com.leoapps.chat.first.presentation.ChatFirstScreen
import com.leoapps.chat.first.presentation.ChatSecondDestination
import com.leoapps.chat.first.presentation.ChatSecondDialog
import com.leoapps.chat.first.presentation.ChatSecondScreen
import com.leoapps.chat.root.presentation.navigation.ChatNavigator
import com.leoapps.navigation.NavigationDestination
import kotlinx.serialization.Serializable

@Serializable
object ChatDestination : NavigationDestination

const val NAVIGATION_ANIM_DURATION = 400

@Composable
fun ChatRootScreen(
    navigator: ChatNavigator
) {
    val navController = rememberNavController()

    val fadeAnimationSpec = tween<Float>(
        durationMillis = NAVIGATION_ANIM_DURATION,
        easing = LinearEasing
    )
    val slideAnimationSpec = tween<IntOffset>(
        durationMillis = NAVIGATION_ANIM_DURATION,
        easing = LinearEasing
    )

    NavHost(
        navController = navController,
        startDestination = ChatFirstDestination,
    ) {
        composable<ChatFirstDestination>(
            enterTransition = { fadeIn(fadeAnimationSpec) },
            exitTransition = { fadeOut(fadeAnimationSpec) }
        ) {
            ChatFirstScreen(
                onOpenSecondScreenClicked = {
                    navController.navigate(ChatSecondDestination)
                }
            )
        }
        composable<ChatSecondDestination>(
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = slideAnimationSpec
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.End,
                    animationSpec = slideAnimationSpec
                )
            }
        ) {
            ChatSecondScreen(
                onBackClicked = {
                    navController.navigateUp()
                },
                onDialogOpenClicked = {
                    navController.navigate(ChatSecondDialog)
                }
            )
        }
        dialog<ChatSecondDialog> {
            ChatSecondDialog(
                onDismissRequest = { navController.navigateUp() },
                onNegativeClicked = { navController.navigateUp() },
                onPositiveClicked = {
                    navController.popBackStack(
                        ChatSecondDestination,
                        inclusive = true
                    )
                }
            )
        }
    }
}
