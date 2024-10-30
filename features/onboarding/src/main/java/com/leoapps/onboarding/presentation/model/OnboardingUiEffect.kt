package com.leoapps.onboarding.presentation.model

import com.leoapps.mvi.model.UiEffect

sealed class OnboardingUiEffect : UiEffect {
    data class AnimateToPage(
        val pageIndex: Int
    ) : OnboardingUiEffect()
}