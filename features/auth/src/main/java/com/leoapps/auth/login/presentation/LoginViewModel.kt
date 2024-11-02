package com.leoapps.auth.login.presentation

import androidx.lifecycle.viewModelScope
import com.leoapps.auth.login.domain.LogInUseCase
import com.leoapps.auth.login.presentation.model.LoginNavCommand
import com.leoapps.auth.login.presentation.model.LoginUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val logIn: LogInUseCase,
) : BaseViewModel<LoginUiState, NoEffect, LoginNavCommand>(
    initialState = LoginUiState()
) {
    fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                email = email,
                isLoginEnabled = shouldEnableLogin(email = email)
            )
        }
    }

    fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
                isLoginEnabled = shouldEnableLogin(password = password)
            )
        }
    }

    fun onLoginClicked() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isLoginEnabled = false
                )
            }
            logIn(
                email = state.value.email,
                password = state.value.password
            )
            navigate(
                command = LoginNavCommand.OpenMain
            )
        }
    }

    fun onSignupClicked() {
        navigate(LoginNavCommand.OpenSignUp)
    }

    private fun shouldEnableLogin(
        email: String = state.value.email,
        password: String = state.value.password,
    ): Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }
}
