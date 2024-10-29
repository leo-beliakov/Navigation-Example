package com.leoapps.splash.presentation

import androidx.lifecycle.viewModelScope
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import com.leoapps.mvi.model.NoState
import com.leoapps.onboarding.domain.ShouldShowOnboardingUseCase
import com.leoapps.splash.presentation.model.SplashNavCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    shouldShowOnboarding: ShouldShowOnboardingUseCase
) : BaseViewModel<NoState, NoEffect, SplashNavCommand>() {

    init {
        viewModelScope.launch {
            delay(1000)
            if (shouldShowOnboarding()) {
                navigate(SplashNavCommand.OpenOnboarding)
            } else {
                navigate(SplashNavCommand.OpenMain)
            }
        }
    }
}
