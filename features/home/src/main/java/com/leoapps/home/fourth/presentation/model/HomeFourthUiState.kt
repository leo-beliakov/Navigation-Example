package com.leoapps.home.fourth.presentation.model

import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.mvi.model.UiState

data class HomeFourthUiState(
    val customParam1: HomeCustomParam1,
    val customParam2: HomeCustomParam2,
) : UiState