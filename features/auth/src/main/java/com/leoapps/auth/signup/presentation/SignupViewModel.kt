package com.leoapps.auth.signup.presentation

import androidx.lifecycle.viewModelScope
import com.leoapps.auth.signup.domain.SignUpUseCase
import com.leoapps.auth.signup.presentation.model.SignupNavCommand
import com.leoapps.auth.signup.presentation.model.SignupUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signUp: SignUpUseCase
) : BaseViewModel<SignupUiState, NoEffect, SignupNavCommand>() {

    override fun getInitialState() = SignupUiState()

    fun onNameChanged(name: String) {
        _state.update {
            it.copy(
                name = name,
                isSignupEnabled = shouldEnableSignup(name = name)
            )
        }
    }

    fun onEmailChanged(email: String) {
        _state.update {
            it.copy(
                email = email,
                isSignupEnabled = shouldEnableSignup(email = email)
            )
        }
    }

    fun onPasswordChanged(password: String) {
        _state.update {
            it.copy(
                password = password,
                isSignupEnabled = shouldEnableSignup(password = password)
            )
        }
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _state.update {
            it.copy(
                confirmPassword = confirmPassword,
                isSignupEnabled = shouldEnableSignup(confirmPassword = confirmPassword)
            )
        }
    }

    fun onSignupClicked() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isSignupEnabled = false
                )
            }
            signUp(
                email = state.value.email,
                name = state.value.name,
                password = state.value.password
            )
            navigate(
                command = SignupNavCommand.OpenMain
            )
        }
    }

    fun onLoginClicked() {
        navigate(SignupNavCommand.OpenLogin)
    }

    private fun shouldEnableSignup(
        name: String = state.value.name,
        email: String = state.value.email,
        password: String = state.value.password,
        confirmPassword: String = state.value.confirmPassword,
    ): Boolean {
        return name.isNotBlank() &&
                email.isNotBlank() &&
                password.isNotBlank() &&
                password == confirmPassword
    }
}