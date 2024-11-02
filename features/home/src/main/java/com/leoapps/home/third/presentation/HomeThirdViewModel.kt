package com.leoapps.home.third.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.home.third.presentation.model.HomeThirdNavCommand
import com.leoapps.home.third.presentation.model.HomeThirdUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import javax.inject.Inject

class HomeThirdViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<HomeThirdUiState, NoEffect, HomeThirdNavCommand>(
    initialState = run {
        val args = savedStateHandle.toRoute<HomeThirdDestination>()
        HomeThirdUiState(
            param1 = args.param1,
            param2 = args.param2,
            param3 = args.param3,
            param4 = args.param4,
        )
    }
) {

    fun onBackClicked() {
        navigate(HomeThirdNavCommand.Back)
    }

    fun onGoToFourthScreenClicked() {
        navigate(
            HomeThirdNavCommand.OpenFourthScreen(
                customParam1 = HomeCustomParam1(
                    value1 = true,
                    value2 = EnumParam.VALUE1
                ),
                customParam2 = HomeCustomParam2(
                    value1 = "Some value",
                    value2 = 1234,
                    value3 = HomeCustomParam1(
                        value1 = false,
                        value2 = EnumParam.VALUE2
                    ),
                ),
            )
        )
    }
}
