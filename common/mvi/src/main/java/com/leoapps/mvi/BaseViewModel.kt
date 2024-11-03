package com.leoapps.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoapps.mvi.model.NavigationCommand
import com.leoapps.mvi.model.UiEffect
import com.leoapps.mvi.model.UiState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Base ViewModel managing UI state, effects, and navigation commands.
 *
 * @param State Type representing the view's state.
 * @param Effect Type representing one-time events for the UI.
 * @param NavCommand Type representing navigation instructions.
 */
abstract class BaseViewModel<State : UiState, Effect : UiEffect, NavCommand : NavigationCommand>(
    initialState: State
) : ViewModel() {

    /**
     * Holds the current view state, exposed as [state].
     */
    protected val _state = MutableStateFlow<State>(initialState)
    val state = _state.asStateFlow()

    /**
     * Flow for emitting one-time [Effect]s, exposed as [uiEffects] for UI consumption.
     */
    protected val _uiEffects = MutableSharedFlow<Effect>()
    val uiEffects = _uiEffects.asSharedFlow()

    /**
     * Flow for navigation instructions, exposed as [navigationCommands].
     */
    private val _navigationCommands = MutableSharedFlow<NavCommand>()
    val navigationCommands = _navigationCommands.asSharedFlow()

    protected fun navigate(command: NavCommand) {
        viewModelScope.launch {
            _navigationCommands.emit(command)
        }
    }

    protected fun sendUiEffect(effect: Effect) {
        viewModelScope.launch {
            _uiEffects.emit(effect)
        }
    }
}
