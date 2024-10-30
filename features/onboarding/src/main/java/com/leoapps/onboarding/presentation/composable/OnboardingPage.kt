package com.leoapps.onboarding.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leoapps.onboarding.presentation.model.OnboardingUiState

@Composable
fun OnboardingPage(
    page: OnboardingUiState.Page
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(page.image),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = null
        )
        Text(
            text = stringResource(page.title),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = stringResource(page.description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
private fun OnboardingPagePreview() {
    OnboardingPage(
        page = OnboardingUiState.Page.WELCOME
    )
}