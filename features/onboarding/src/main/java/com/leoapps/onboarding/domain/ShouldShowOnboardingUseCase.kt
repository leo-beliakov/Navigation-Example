package com.leoapps.onboarding.domain

import com.leoapps.onboarding.domain.repository.OnboardingRepository
import javax.inject.Inject

class ShouldShowOnboardingUseCase @Inject constructor(
    private val onboardingRepository: OnboardingRepository
) {
    suspend operator fun invoke(): Boolean = !onboardingRepository.isOnboardingShown()
}