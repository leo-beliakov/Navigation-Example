package com.leoapps.home.third.presentation

import android.util.Log
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
) : BaseViewModel<HomeThirdUiState, NoEffect, HomeThirdNavCommand>() {

    val args = savedStateHandle.toRoute<HomeThirdDestination>()

    init {
        Log.d("MyTag", "args: $args")
    }

    override fun getInitialState() = HomeThirdUiState(
        param1 = 123,
        param2 = "Some value",
        param3 = true,
        param4 = EnumParam.VALUE1,
    )

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