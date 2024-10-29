package com.leoapps.onboarding.di

import com.leoapps.onboarding.data.OnboardingRepositoryImpl
import com.leoapps.onboarding.domain.repository.OnboardingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface OnboardingModule {

    @Binds
    fun bindOnboardingRepository(impl: OnboardingRepositoryImpl): OnboardingRepository
}