package com.leoapps.home.third.presentation.model

import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.home.base.domain.model.HomeCustomParam2
import com.leoapps.mvi.model.UiState

data class HomeThirdUiState(
    val param1: Int,
    val param2: String,
    val param3: Boolean,
    val param4: EnumParam,
    val generatedParam1: HomeCustomParam1? = null,
    val generatedParam2: HomeCustomParam2? = null,
    val isNavigateNextEnabled: Boolean = false,
) : UiState