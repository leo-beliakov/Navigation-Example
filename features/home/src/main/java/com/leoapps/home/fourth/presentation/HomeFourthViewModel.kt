package com.leoapps.home.fourth.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.leoapps.home.base.domain.getRandomEnumParamValue
import com.leoapps.home.base.domain.getRandomHomeCustomParam1
import com.leoapps.home.base.domain.getRandomString
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam1NavType
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.home.base.domain.model.HomeCustomParam2NavType
import com.leoapps.home.fourth.presentation.model.HomeFourthNavCommand
import com.leoapps.home.fourth.presentation.model.HomeFourthUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
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
                listParam1 = state.value.generatedParam1,
                listParam2 = state.value.generatedParam2,
                listParam3 = state.value.generatedParam3,
            )
        )
    }

    fun onGenerateParamsClicked() {
        _state.update {
            it.copy(
                isNavigateNextEnabled = true,
                generatedParam1 = listOf(getRandomString(), getRandomString()),
                generatedParam2 = listOf(getRandomEnumParamValue(), getRandomEnumParamValue()),
                generatedParam3 = listOf(getRandomHomeCustomParam1(), getRandomHomeCustomParam1()),
            )
        }
    }
}
