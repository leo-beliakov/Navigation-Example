package com.leoapps.onboarding.presentation

import androidx.lifecycle.viewModelScope
import com.leoapps.mvi.BaseViewModel
import com.leoapps.onboarding.domain.SetOnboardingShownUseCase
import com.leoapps.onboarding.presentation.model.OnboardingNavCommand
import com.leoapps.onboarding.presentation.model.OnboardingUiEffect
import com.leoapps.onboarding.presentation.model.OnboardingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    setOnboardingShown: SetOnboardingShownUseCase,
) : BaseViewModel<OnboardingUiState, OnboardingUiEffect, OnboardingNavCommand>(
    initialState = OnboardingUiState(
        seletedPage = 0,
        isLastPage = false,
    )
) {

    init {
        viewModelScope.launch {
            setOnboardingShown()
        }
    }

    fun onNextClicked() {
        updateStateWithNewPage(state.value.seletedPage + 1)
        animateToNextPage()
    }

    fun onSkipClicked() {
        navigate(OnboardingNavCommand.OpenAuth)
    }

    fun onContinueClicked() {
        navigate(OnboardingNavCommand.OpenAuth)
    }

    fun onPageScrolled(currentPage: Int) {
        updateStateWithNewPage(currentPage)
    }

    private fun updateStateWithNewPage(currentPage: Int) {
        _state.update {
            it.copy(
                seletedPage = currentPage,
                isLastPage = currentPage == it.pages.lastIndex
            )
        }
    }

    private fun animateToNextPage() {
        sendUiEffect(
            OnboardingUiEffect.AnimateToPage(state.value.seletedPage)
        )
    }
}