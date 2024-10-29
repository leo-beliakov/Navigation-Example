package com.leoapps.onboarding.data

import android.content.Context
import android.content.SharedPreferences
import com.leoapps.onboarding.domain.repository.OnboardingRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OnboardingRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : OnboardingRepository {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        ONBOARDING_PREFS,
        Context.MODE_PRIVATE
    )

    override suspend fun isOnboardingShown(): Boolean = withContext(Dispatchers.IO) {
        sharedPref.getBoolean(IS_ONBOARDING_SHOWN_KEY, false)
    }

    override suspend fun setOnboardingShown(isShown: Boolean): Unit = withContext(Dispatchers.IO) {
        sharedPref.edit().putBoolean(IS_ONBOARDING_SHOWN_KEY, isShown).commit()
    }

    private companion object {
        const val ONBOARDING_PREFS = "onboarding_prefs"
        const val IS_ONBOARDING_SHOWN_KEY = "is_onboarding_shown"
    }
}