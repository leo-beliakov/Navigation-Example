package com.leoapps.auth.login.presentation.model

import com.leoapps.mvi.model.UiState

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoginEnabled: Boolean = false,
    val isLoading: Boolean = false,
) : UiState