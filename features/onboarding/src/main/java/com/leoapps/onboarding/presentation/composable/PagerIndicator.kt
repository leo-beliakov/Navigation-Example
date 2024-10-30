package com.leoapps.onboarding.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PagerIndicator(
    currentPage: Int,
    numberOfPages: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier,
    ) {
        repeat(numberOfPages) { index ->
            val isSelected = index == currentPage
            IndicatorItem(isSelected = isSelected)
        }
    }
}

@Composable
private fun IndicatorItem(
    isSelected: Boolean
) {
    val color = if (isSelected) Color.White else Color.Black
    Spacer(
        modifier = Modifier
            .size(8.dp)
            .background(
                color = color,
                shape = CircleShape
            )
    )
}

@Preview
@Composable
private fun PagerIndicatorPreview() {
    PagerIndicator(
        currentPage = 1,
        numberOfPages = 3,
    )
}