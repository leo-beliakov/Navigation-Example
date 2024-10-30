package com.leoapps.onboarding.di

import com.leoapps.onboarding.data.ProfileRepositoryImpl
import com.leoapps.onboarding.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ProfileModule {

    @Binds
    fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository
}