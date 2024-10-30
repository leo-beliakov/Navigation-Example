package com.leoapps.onboarding.presentation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.leoapps.mvi.model.UiState
import com.leoapps.onboarding.R

data class OnboardingUiState(
    val seletedPage: Int = 0,
    val pages: List<Page> = Page.entries,
    val isLastPage: Boolean,
) : UiState {

    enum class Page(
        @StringRes val title: Int,
        @StringRes val description: Int,
        @DrawableRes val image: Int,
        val backgroundColor: Color,
    ) {
        WELCOME(
            title = R.string.onboarding_welocme_page_title,
            description = R.string.onboarding_welocme_page_description,
            image = R.drawable.img_onboarding_welcome,
            backgroundColor = Color(0xFFECF0C0),
        ),
        PROGRESS(
            title = R.string.onboarding_progress_page_title,
            description = R.string.onboarding_progress_page_description,
            image = R.drawable.img_onboarding_progress,
            backgroundColor = Color(0xFFFDC9D2),
        ),
        GET_STARTED(
            title = R.string.onboarding_get_started_page_title,
            description = R.string.onboarding_get_started_page_description,
            image = R.drawable.img_onboarding_get_started,
            backgroundColor = Color(0xFFE1FFED),
        )
    }
}
