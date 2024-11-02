package com.leoapps.home.fourth.presentation.model

import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.mvi.model.NavigationCommand

sealed class HomeFourthNavCommand : NavigationCommand {
    object Back : HomeFourthNavCommand()

    data class OpenFifthScreen(
        val listParam1: List<String>,
        val listParam2: List<EnumParam>,
        val listParam3: List<HomeCustomParam1>,
    ) : HomeFourthNavCommand()
}
