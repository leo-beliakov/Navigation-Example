package com.leoapps.onboarding.data

import android.content.Context
import android.content.SharedPreferences
import com.leoapps.onboarding.domain.repository.ProfileRepository
import com.leoapps.profile.domain.model.ProfileData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : ProfileRepository {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        PROFILE_PREFS,
        Context.MODE_PRIVATE
    )

    override suspend fun setProfileData(data: ProfileData): Unit = withContext(Dispatchers.IO) {
        sharedPref.edit()
            .putString(PROFILE_NAME_KEY, data.name)
            .putString(PROFILE_EMAIL_KEY, data.email)
            .commit()
    }

    override suspend fun getProfileData(): ProfileData = withContext(Dispatchers.IO) {
        val name = sharedPref.getString(PROFILE_NAME_KEY, "") ?: ""
        val email = sharedPref.getString(PROFILE_EMAIL_KEY, "") ?: ""
        return@withContext ProfileData(name, email)
    }

    private companion object {
        const val PROFILE_PREFS = "profile_prefs"
        const val PROFILE_NAME_KEY = "profile_name"
        const val PROFILE_EMAIL_KEY = "profile_email"
    }
}