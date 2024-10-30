package com.leoapps.onboarding.domain.repository

import com.leoapps.profile.domain.model.ProfileData

interface ProfileRepository {
    suspend fun setProfileData(data: ProfileData)
    suspend fun getProfileData(): ProfileData
}