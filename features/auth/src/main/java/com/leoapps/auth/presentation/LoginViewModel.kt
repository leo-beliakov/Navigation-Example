package com.leoapps.auth.presentation

import com.leoapps.auth.presentation.model.LoginNavCommand
import com.leoapps.auth.presentation.model.LoginUiState
import com.leoapps.mvi.BaseViewModel
import com.leoapps.mvi.model.NoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :
    BaseViewModel<LoginUiState, NoEffect, LoginNavCommand>() {

    fun onLoginClicked() {
        if (state.value.email.isEmpty() || state.value.password.isEmpty()) {
            //error
            return
        }
        //Show loading
        // Call login use case
    }

    fun onSignUpClicked() {
        navigate(LoginNavCommand.OpenSignUp)
    }

    override fun getInitialState() = LoginUiState()
}