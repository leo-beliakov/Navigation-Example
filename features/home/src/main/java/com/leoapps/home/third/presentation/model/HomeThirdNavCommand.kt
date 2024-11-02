package com.leoapps.home.third.presentation.model

import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.mvi.model.NavigationCommand

sealed class HomeThirdNavCommand : NavigationCommand {
    object Back : HomeThirdNavCommand()

    data class OpenFourthScreen(
        val customParam1: HomeCustomParam1,
        val customParam2: HomeCustomParam2,
    ) : HomeThirdNavCommand()
}