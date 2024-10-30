package com.leoapps.onboarding.presentation.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonsSection(
    isLastPage: Boolean,
    onSkipClicked: () -> Unit,
    onNextClicked: () -> Unit,
    onContinueClicked: () -> Unit,
) {
    if (isLastPage) {
        Button(
            onClick = onContinueClicked,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Let’s Start")
        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onSkipClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Skip")
            }
            Button(
                onClick = onNextClicked,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview
@Composable
private fun ButtonsSectionPreview() {
    ButtonsSection(
        isLastPage = false,
        onSkipClicked = {},
        onNextClicked = {},
        onContinueClicked = {},
    )
}

@Preview
@Composable
private fun ButtonsSectionWhenLastPreview() {
    ButtonsSection(
        isLastPage = true,
        onSkipClicked = {},
        onNextClicked = {},
        onContinueClicked = {},
    )
}