package com.leoapps.onboarding.presentation

import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import com.leoapps.onboarding.presentation.model.OnboardingNavCommand
import com.leoapps.onboarding.presentation.model.OnboardingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
) : BaseViewModel<OnboardingUiState, NoEffect, OnboardingNavCommand>() {

    fun onNextClicked() {
        _state.update {
            val nextPage = it.seletedPage + 1
            val isLastPage = nextPage == it.pages.lastIndex

            it.copy(
                seletedPage = nextPage,
                isLastPage = isLastPage
            )
        }
    }

    fun onSkipClicked() {
        navigate(OnboardingNavCommand.OpenMain)
    }

    fun onContinueClicked() {
        navigate(OnboardingNavCommand.OpenMain)
    }

    override fun getInitialState() = OnboardingUiState(
        seletedPage = 0,
        isLastPage = false,
    )
}