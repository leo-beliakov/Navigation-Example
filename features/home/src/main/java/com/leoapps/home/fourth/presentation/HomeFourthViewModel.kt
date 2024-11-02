package com.leoapps.home.fourth.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam1NavType
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.home.base.domain.model.HomeCustomParam2NavType
import com.leoapps.home.fourth.presentation.model.HomeFourthNavCommand
import com.leoapps.home.fourth.presentation.model.HomeFourthUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.typeOf

@HiltViewModel
class HomeFourthViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<HomeFourthUiState, NoEffect, HomeFourthNavCommand>(
    initialState = run {
        val args = savedStateHandle.toRoute<HomeFourthDestination>(
            typeMap = mapOf(
                typeOf<HomeCustomParam1>() to HomeCustomParam1NavType,
                typeOf<HomeCustomParam2>() to HomeCustomParam2NavType,
            )
        )

        HomeFourthUiState(
            customParam1 = args.customParam1,
            customParam2 = args.customParam2,
        )
    }
) {

    fun onBackClicked() {
        navigate(HomeFourthNavCommand.Back)
    }

    fun onGoToFifthScreenClicked() {
        navigate(
            HomeFourthNavCommand.OpenFifthScreen(
                listParam1 = listOf("param1", "param2"),
                listParam2 = listOf(
                    EnumParam.VALUE1,
                    EnumParam.VALUE2,
                ),
                listParam3 = listOf(
                    HomeCustomParam1(
                        value1 = true,
                        value2 = EnumParam.VALUE1
                    ),
                    HomeCustomParam1(
                        value1 = false,
                        value2 = EnumParam.VALUE2
                    ),
                ),
            )
        )
    }
}
