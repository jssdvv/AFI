package com.jssdvv.afi.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.TabNavigator
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun NavigationBar(
    tabNavigator: TabNavigator,
    navigationItems: List<NavigationTabs>
) {
    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = NavigationBarDefaults.Elevation,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        var selectedItem by rememberSaveable { mutableStateOf(0) }
        navigationItems.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                selected = tabNavigator.current == navigationItem.tab,
                onClick = {
                    selectedItem = index
                    tabNavigator.current = navigationItem.tab
                },
                icon = {
                    if (selectedItem == index) {
                        Icon(
                            imageVector = navigationItem.activeIcon,
                            contentDescription = stringResource(navigationItem.title)
                        )
                    } else {
                        Icon(
                            imageVector = navigationItem.inactiveIcon,
                            contentDescription = stringResource(navigationItem.title)
                        )
                    }
                },
                modifier = Modifier,
                enabled = true,
                label = { Text(stringResource(navigationItem.title)) },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(),
            )
        }
    }
}