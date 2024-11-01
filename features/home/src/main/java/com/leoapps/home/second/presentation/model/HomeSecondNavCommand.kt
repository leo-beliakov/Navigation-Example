package com.leoapps.home.second.presentation.model

import com.leoapps.home.third.presentation.HomeThirdDestination
import com.leoapps.mvi.model.NavigationCommand

sealed class HomeSecondNavCommand : NavigationCommand {
    object Back : HomeSecondNavCommand()

    data class OpenThirdScreen(
        val param1: Int,
        val param2: String,
        val param3: Boolean,
        val param4: HomeThirdDestination.Param4,
    ) : HomeSecondNavCommand()
}