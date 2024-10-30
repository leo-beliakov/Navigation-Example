package com.leoapps.onboarding.domain

import com.leoapps.onboarding.domain.repository.ProfileRepository
import com.leoapps.profile.domain.model.ProfileData
import javax.inject.Inject

class SaveProfileDataUseCase @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend operator fun invoke(profileData: ProfileData) {
        profileRepository.setProfileData(profileData)
    }
}