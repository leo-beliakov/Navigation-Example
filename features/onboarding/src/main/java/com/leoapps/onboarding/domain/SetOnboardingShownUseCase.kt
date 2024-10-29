package com.leoapps.onboarding.domain

import com.leoapps.onboarding.domain.repository.OnboardingRepository
import javax.inject.Inject

class SetOnboardingShownUseCase @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) {
    suspend operator fun invoke() {
        onboardingRepository.setOnboardingShown(true)
    }
}