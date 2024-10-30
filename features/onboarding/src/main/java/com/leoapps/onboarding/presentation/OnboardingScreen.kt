package com.leoapps.feature_b.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leoapps.mvi.utils.CollectEventsWithLifecycle
import com.leoapps.onboarding.presentation.OnboardingViewModel
import com.leoapps.onboarding.presentation.composable.ButtonsSection
import com.leoapps.onboarding.presentation.composable.OnboardingPage
import com.leoapps.onboarding.presentation.composable.PagerIndicator
import com.leoapps.onboarding.presentation.model.OnboardingUiEffect
import com.leoapps.onboarding.presentation.model.OnboardingUiState
import com.leoapps.onboarding.presentation.navigator.OnboardingNavigator
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
object OnboardingDestination

@Composable
fun OnboardingScreen(
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigator: OnboardingNavigator,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState { state.pages.size }
    val animationScope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        viewModel.onPageScrolled(pagerState.currentPage)
    }

    OnboardingScreen(
        state = state,
        pagerState = pagerState,
        onNextClicked = viewModel::onNextClicked,
        onSkipClicked = viewModel::onSkipClicked,
        onContinueClicked = viewModel::onContinueClicked,
    )

    CollectEventsWithLifecycle(viewModel.uiEffects) { effect ->
        when (effect) {
            is OnboardingUiEffect.AnimateToPage -> {
                animationScope.launch {
                    pagerState.animateScrollToPage(effect.pageIndex)
                }
            }
        }
    }

    CollectEventsWithLifecycle(viewModel.navigationCommands) { navCommand ->
        navigator.onNavCommand(navCommand)
    }
}

@Composable
private fun OnboardingScreen(
    state: OnboardingUiState,
    pagerState: PagerState,
    onNextClicked: () -> Unit,
    onSkipClicked: () -> Unit,
    onContinueClicked: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(state.pages[state.seletedPage].backgroundColor)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            OnboardingPage(
                page = state.pages[page],
                modifier = Modifier.padding(horizontal = 24.dp),
            )
        }
        PagerIndicator(
            currentPage = state.seletedPage,
            numberOfPages = state.pages.size,
            modifier = Modifier.padding(top = 16.dp)
        )
        ButtonsSection(
            isLastPage = state.isLastPage,
            onSkipClicked = onSkipClicked,
            onNextClicked = onNextClicked,
            onContinueClicked = onContinueClicked,
            modifier = Modifier.padding(
                top = 24.dp,
                start = 32.dp,
                end = 32.dp,
                bottom = 48.dp
            ),
        )
    }
}