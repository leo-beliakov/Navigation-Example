package com.leoapps.home.fifth.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.EnumParamListNavType
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam1ListNavType
import com.leoapps.home.fifth.presentation.model.HomeFifthNavCommand
import com.leoapps.home.fifth.presentation.model.HomeFifthUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.typeOf

@HiltViewModel
class HomeFifthViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<HomeFifthUiState, NoEffect, HomeFifthNavCommand>(
    initialState = run {
        val args = savedStateHandle.toRoute<HomeFifthDestination>(
            typeMap = mapOf(
                typeOf<List<EnumParam>>() to EnumParamListNavType,
                typeOf<List<HomeCustomParam1>>() to HomeCustomParam1ListNavType
            )
        )
        HomeFifthUiState(
            listParam1 = args.listParam1,
            listParam2 = args.listParam2,
            listParam3 = args.listParam3,
        )
    }
) {

    fun onBackClicked() {
        navigate(HomeFifthNavCommand.Back)
    }

    fun onGoToFirstScreenClicked() {
        navigate(HomeFifthNavCommand.OpenFirst)
    }

    fun onOpenChatClicked() {
        navigate(HomeFifthNavCommand.OpenChat)
    }
}