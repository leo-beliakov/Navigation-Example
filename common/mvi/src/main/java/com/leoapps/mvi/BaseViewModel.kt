package com.leoapps.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leoapps.mvi.model.NoState
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
abstract class BaseViewModel<State, Effect, NavCommand> : ViewModel() {

    /**
     * Holds the current view state, initialized by [getInitialState] and exposed as [state].
     */
    private val _state = MutableStateFlow(getInitialState())
    val state = _state.asStateFlow()

    /**
     * Flow for emitting one-time [Effect]s, exposed as [sideEffects] for UI consumption.
     */
    private val _sideEffects = MutableSharedFlow<Effect>()
    val sideEffects = _sideEffects.asSharedFlow()

    /**
     * Flow for navigation instructions, exposed as [navigationCommands].
     */
    private val _navigationCommands = MutableSharedFlow<NavCommand>()
    val navigationCommands = _navigationCommands.asSharedFlow()

    protected open fun getInitialState() = NoState

    protected fun navigate(command: NavCommand) {
        viewModelScope.launch {
            _navigationCommands.emit(command)
        }
    }
}
