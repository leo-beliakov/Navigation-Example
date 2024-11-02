package com.leoapps.home.first.presentation

import com.leoapps.home.first.presentation.model.HomeFirstNavCommand
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import com.leoapps.mvi.model.NoState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFirstViewModel @Inject constructor() :
    BaseViewModel<NoState, NoEffect, HomeFirstNavCommand>() {

    override fun getInitialState() = NoState

    fun onGoToSecondScreenClicked() {
        navigate(HomeFirstNavCommand.OpenSecondScreen)
    }
}