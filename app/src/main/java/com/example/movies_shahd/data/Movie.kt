package com.example.movies_shahd.data

data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val rating: Float,
    val year: Int,
    val isFavorite: Boolean = false
)

// Sample data for demonstration
object MovieDataSource {
    val sampleMovies = listOf(
        Movie(1, "Harry Potter and the Philosopher's Stone", "", 7.6f, 2001),
        Movie(2, "Harry Potter and the Chamber of Secrets", "", 7.4f, 2002),
        Movie(3, "Harry Potter and the Prisoner of Azkaban", "", 7.9f, 2004),
        Movie(4, "Iron Man", "", 7.9f, 2008),
        Movie(5, "The Avengers", "", 8.0f, 2012),
        Movie(6, "Black Panther", "", 7.3f, 2018),
    )
}
