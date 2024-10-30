package com.leoapps.profile.presentation.model

import com.leoapps.mvi.model.UiState

data class ProfileUiState(
    val username: String,
    val email: String,
) : UiState
