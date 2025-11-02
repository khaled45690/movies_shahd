package com.example.movies_shahd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies_shahd.data.Movie
import com.example.movies_shahd.ui.theme.DarkSurface
import com.example.movies_shahd.ui.theme.RatingYellow
import com.example.movies_shahd.ui.theme.TextPrimary
import com.example.movies_shahd.ui.theme.TextSecondary

@Composable
fun MovieCard(
    movie: Movie,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit = {},
    onFavoriteClick: (Movie) -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .height(240.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = DarkSurface
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Movie Poster
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Gray)
            ) {
                // TODO: Add Coil image loading here
                // AsyncImage(model = movie.posterUrl, contentDescription = movie.title)
                
                // Placeholder for now
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Poster",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
            }
            
            // Movie Info
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Title
                Text(
                    text = movie.title,
                    color = TextPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                // Rating and Year
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Rating
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = RatingYellow,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = movie.rating.toString(),
                            color = TextPrimary,
                            fontSize = 12.sp
                        )
                    }
                    
                    // Year
                    Text(
                        text = movie.year.toString(),
                        color = TextSecondary,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
