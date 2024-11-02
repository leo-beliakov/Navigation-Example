package com.leoapps.home.fifth.presentation

import android.util.Log
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
) : BaseViewModel<HomeFifthUiState, NoEffect, HomeFifthNavCommand>() {

    val args = savedStateHandle.toRoute<HomeFifthDestination>(
        typeMap = mapOf(
            typeOf<List<EnumParam>>() to EnumParamListNavType,
            typeOf<List<HomeCustomParam1>>() to HomeCustomParam1ListNavType
        )
    )

    init {
        Log.d("MyTag", "args: $args")
    }

    override fun getInitialState() = HomeFifthUiState()

    fun onBackClicked() {
        navigate(HomeFifthNavCommand.Back)
    }

    fun onGoToFifthScreenClicked() {}
}