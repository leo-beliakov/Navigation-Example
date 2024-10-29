package com.leoapps.onboarding.domain.repository

interface OnboardingRepository {
    suspend fun isOnboardingShown(): Boolean
    suspend fun setOnboardingShown(isShown: Boolean)
}