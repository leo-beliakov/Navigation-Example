package com.leoapps.home.fifth.presentation.model

import com.leoapps.home.base.domain.model.EnumParam
import com.leoapps.home.base.domain.model.HomeCustomParam1
import com.leoapps.mvi.model.UiState

data class HomeFifthUiState(
    val listParam1: List<String>,
    val listParam2: List<EnumParam>,
    val listParam3: List<HomeCustomParam1>,
) : UiState