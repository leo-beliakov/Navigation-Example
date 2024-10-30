package com.leoapps.onboarding.domain

import com.leoapps.onboarding.domain.repository.ProfileRepository
import javax.inject.Inject

class GetProfileDataUseCaseUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(): Boolean = !profileRepository.setProfileData()
}