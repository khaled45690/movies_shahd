package com.example.movies_shahd.ui.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies_shahd.data.Movie
import com.example.movies_shahd.ui.components.BottomNavigationBar
import com.example.movies_shahd.ui.components.EmptyFavoritesState
import com.example.movies_shahd.ui.components.MovieCard
import com.example.movies_shahd.ui.components.NavigationItem
import com.example.movies_shahd.ui.screens.FavoritesScreen
import com.example.movies_shahd.ui.screens.HomeScreen
import com.example.movies_shahd.ui.theme.Movies_shahdTheme

// Preview for MovieCard Component
@Preview(showBackground = true, backgroundColor = 0xFF1A1D29)
@Composable
fun MovieCardPreview() {
    Movies_shahdTheme {
        MovieCard(
            movie = Movie(
                id = 1,
                title = "Harry Potter and the Philosopher's Stone",
                posterUrl = "",
                rating = 7.6f,
                year = 2001
            )
        )
    }
}

// Preview for Empty Favorites State
@Preview(showBackground = true, backgroundColor = 0xFF1A1D29)
@Composable
fun EmptyFavoritesStatePreview() {
    Movies_shahdTheme {
        EmptyFavoritesState(
            onDiscoverClick = {}
        )
    }
}

// Preview for Bottom Navigation Bar
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    Movies_shahdTheme {
        BottomNavigationBar(
            selectedItem = NavigationItem.FAVORITES,
            onItemSelected = {}
        )
    }
}

// Preview for Favorites Screen (Empty State)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoritesScreenEmptyPreview() {
    Movies_shahdTheme {
        FavoritesScreen(
            favoriteMovies = emptyList(),
            onDiscoverClick = {}
        )
    }
}

// Preview for Favorites Screen (With Movies)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FavoritesScreenWithMoviesPreview() {
    Movies_shahdTheme {
        FavoritesScreen(
            favoriteMovies = listOf(
                Movie(1, "Harry Potter", "", 7.6f, 2001),
                Movie(2, "Iron Man", "", 7.9f, 2008),
                Movie(3, "The Avengers", "", 8.0f, 2012),
                Movie(4, "Black Panther", "", 7.3f, 2018)
            ),
            onDiscoverClick = {}
        )
    }
}

// Preview for Home Screen
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Movies_shahdTheme {
        HomeScreen(
            movies = listOf(
                Movie(1, "Harry Potter", "", 7.6f, 2001),
                Movie(2, "Iron Man", "", 7.9f, 2008),
                Movie(3, "The Avengers", "", 8.0f, 2012),
                Movie(4, "Black Panther", "", 7.3f, 2018),
                Movie(5, "Spider-Man", "", 8.2f, 2021),
                Movie(6, "Thor", "", 7.0f, 2011)
            )
        )
    }
}
