package com.leoapps.splash.presentation

import androidx.lifecycle.viewModelScope
import com.leoapps.auth.base.domain.IsUserLoggedInUseCase
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
    shouldShowOnboarding: ShouldShowOnboardingUseCase,
    isUserLoggedIn: IsUserLoggedInUseCase,
) : BaseViewModel<NoState, NoEffect, SplashNavCommand>(
    initialState = NoState
) {

    init {
        viewModelScope.launch {
            // Hardcode delay for splash screen
            delay(1000)

            when {
                shouldShowOnboarding() -> navigate(SplashNavCommand.OpenOnboarding)
                isUserLoggedIn() -> navigate(SplashNavCommand.OpenMain)
                else -> navigate(SplashNavCommand.OpenAuth)
            }
        }
    }
}
