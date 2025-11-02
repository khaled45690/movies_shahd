package com.example.movies_shahd.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movies_shahd.ui.theme.AccentPurple
import com.example.movies_shahd.ui.theme.TextPrimary
import com.example.movies_shahd.ui.theme.TextSecondary

@Composable
fun EmptyFavoritesState(
    onDiscoverClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Heart Icon
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(
                    color = Color(0xFF2D3142),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = "No favorites",
                modifier = Modifier.size(60.dp),
                tint = TextSecondary
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Title
        Text(
            text = "No favorites yet",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Description
        Text(
            text = "Start exploring movies and add them to\nyour favorites by tapping the heart icon.",
            fontSize = 14.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Discover Button
        Button(
            onClick = onDiscoverClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = AccentPurple
            ),
            modifier = Modifier
                .height(48.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Discover Movies",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
