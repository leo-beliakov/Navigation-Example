package com.leoapps.auth.signup.presentation.model

import com.leoapps.mvi.model.UiState

data class SignupUiState(
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isSignupEnabled: Boolean = false,
    val isLoading: Boolean = false,
) : UiState