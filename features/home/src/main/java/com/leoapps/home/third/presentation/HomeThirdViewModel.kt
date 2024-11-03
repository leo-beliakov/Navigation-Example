package com.leoapps.home.third.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.leoapps.home.base.domain.getRandomHomeCustomParam1
import com.leoapps.home.base.domain.getRandomHomeCustomParam2
import com.leoapps.home.third.presentation.model.HomeThirdNavCommand
import com.leoapps.home.third.presentation.model.HomeThirdUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import kotlinx.coroutines.flow.update
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
        val param1 = state.value.generatedParam1 ?: return
        val param2 = state.value.generatedParam2 ?: return

        navigate(
            HomeThirdNavCommand.OpenFourthScreen(
                customParam1 = param1,
                customParam2 = param2,
            )
        )
    }

    fun onGenerateParamsClicked() {
        _state.update {
            it.copy(
                isNavigateNextEnabled = true,
                generatedParam1 = getRandomHomeCustomParam1(),
                generatedParam2 = getRandomHomeCustomParam2()
            )
        }
    }
}
