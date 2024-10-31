package com.leoapps.auth.presentation.model

import com.leoapps.mvi.model.UiState

data class LoginUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
) : UiState