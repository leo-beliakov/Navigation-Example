package com.leoapps.profile.presentation

import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import com.leoapps.profile.presentation.model.ProfileNavCommand
import com.leoapps.profile.presentation.model.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
) : BaseViewModel<ProfileUiState, NoEffect, ProfileNavCommand>(
    initialState = ProfileUiState(
        username = "Leo",
        email = "leo.baervrsdf@der.esce"
    )
) {

    fun onLogoutClicked() {
        navigate(ProfileNavCommand.OpenAuth)
    }
}