package com.leoapps.main.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.leoapps.main.ui.model.BottomNavItem

@Composable
fun RowScope.HomeNavBarItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onTabClick: () -> Unit,
) {
    NavigationBarItem(
        icon = {
            Icon(
                painterResource(id = item.icon),
                contentDescription = item.title
            )
        },
        label = { Text(item.title) },
        selected = isSelected,
        onClick = onTabClick
    )
}
