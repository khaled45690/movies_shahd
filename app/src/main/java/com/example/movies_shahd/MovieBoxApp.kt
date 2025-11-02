package com.example.movies_shahd

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.movies_shahd.data.MovieDataSource
import com.example.movies_shahd.ui.components.BottomNavigationBar
import com.example.movies_shahd.ui.components.NavigationItem
import com.example.movies_shahd.ui.screens.*
import com.example.movies_shahd.ui.theme.DarkBackground

@Composable
fun MovieBoxApp() {
    var selectedItem by remember { mutableStateOf(NavigationItem.HOME) }
    
    Scaffold(
        containerColor = DarkBackground,
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )
        }
    ) { paddingValues ->
        when (selectedItem) {
            NavigationItem.HOME -> {
                HomeScreen(
                    movies = MovieDataSource.sampleMovies,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
            NavigationItem.SEARCH -> {
                SearchScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
            NavigationItem.FAVORITES -> {
                FavoritesScreen(
                    favoriteMovies = emptyList(), // Empty for now to show empty state
                    onDiscoverClick = { selectedItem = NavigationItem.HOME },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
            NavigationItem.PROFILE -> {
                ProfileScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                )
            }
        }
    }
}
