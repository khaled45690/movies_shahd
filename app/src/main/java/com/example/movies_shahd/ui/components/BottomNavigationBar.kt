package com.example.movies_shahd.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.movies_shahd.ui.theme.AccentPurple
import com.example.movies_shahd.ui.theme.DarkSurface
import com.example.movies_shahd.ui.theme.TextPrimary
import com.example.movies_shahd.ui.theme.TextSecondary

enum class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    HOME("Home", Icons.Default.Home, "home"),
    SEARCH("Search", Icons.Default.Search, "search"),
    FAVORITES("Favorites", Icons.Default.Favorite, "favorites"),
    PROFILE("Profile", Icons.Default.Person, "profile")
}

@Composable
fun BottomNavigationBar(
    selectedItem: NavigationItem,
    onItemSelected: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = DarkSurface,
        tonalElevation = 8.dp
    ) {
        NavigationItem.entries.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                },
                selected = selectedItem == item,
                onClick = { onItemSelected(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AccentPurple,
                    selectedTextColor = AccentPurple,
                    unselectedIconColor = TextSecondary,
                    unselectedTextColor = TextSecondary,
                    indicatorColor = AccentPurple.copy(alpha = 0.2f)
                )
            )
        }
    }
}
