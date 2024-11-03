package com.leoapps.home.fourth.presentation.model

import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.mvi.model.UiState

data class HomeFourthUiState(
    val customParam1: HomeCustomParam1,
    val customParam2: HomeCustomParam2,
    val generatedParam1: List<String> = emptyList(),
    val generatedParam2: List<EnumParam> = emptyList(),
    val generatedParam3: List<HomeCustomParam1> = emptyList(),
    val isNavigateNextEnabled: Boolean = false,
) : UiState