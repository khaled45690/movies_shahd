# Quick Start Guide - MovieBox App

## 🚀 Getting Started

### Step 1: Sync Project

1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. If you see any sync errors, click "Sync Now" or "Try Again"

### Step 2: Build the App

```bash
# In Android Studio, click the green "Run" button
# Or use terminal:
./gradlew assembleDebug
```

### Step 3: Run on Device/Emulator

- Select your device/emulator from the dropdown
- Click the green "Run" button
- The app will install and launch automatically

## 📱 What You'll See

### Home Screen (Default)

- Grid of 6 sample movies
- Bottom navigation bar with 4 tabs
- Dark theme throughout

### Favorites Screen ⭐ (Main Focus)

To view the Favorites screen:

1. Launch the app
2. Tap the "Favorites" tab (heart icon) in the bottom navigation
3. You'll see the **empty state** with:
   - Heart icon in a circle
   - "No favorites yet" message
   - Description text
   - "Discover Movies" button

## 🎨 Component Locations

### Main Components (Ready to Use)

```
ui/components/
├── MovieCard.kt              - Movie display card
├── EmptyFavoritesState.kt    - Empty state UI
└── BottomNavigationBar.kt    - Bottom navigation
```

### Screens

```
ui/screens/
├── FavoritesScreen.kt  ⭐ - YOUR MAIN SCREEN
├── HomeScreen.kt           - Reference implementation
├── SearchScreen.kt         - Placeholder
└── ProfileScreen.kt        - Placeholder
```

## 🔧 Testing Components Individually

### Preview in Android Studio

1. Open any component file (e.g., `FavoritesScreen.kt`)
2. Open `ui/previews/Previews.kt`
3. Look for the "Split" or "Design" view in Android Studio
4. You'll see live previews of all components!

### Available Previews

- `MovieCardPreview()` - Single movie card
- `EmptyFavoritesStatePreview()` - Empty state component
- `BottomNavigationBarPreview()` - Navigation bar
- `FavoritesScreenEmptyPreview()` - Favorites with no movies
- `FavoritesScreenWithMoviesPreview()` - Favorites with movies
- `HomeScreenPreview()` - Home screen

## 🎯 Your Focus: Favorites Screen

The **FavoritesScreen** is your main deliverable and includes:

### Features Implemented ✅

1. **Top App Bar**

   - "My Favorites" title in white
   - Back arrow button
   - Dark background

2. **Empty State** (Shows when no favorites)

   - Centered layout
   - Heart icon in circular background
   - "No favorites yet" title
   - Descriptive message
   - Purple "Discover Movies" button

3. **Movies Grid** (Shows when favorites exist)
   - 2-column grid layout
   - Uses MovieCard component
   - Proper spacing and padding

### To Test Both States:

**Empty State (Default):**

```kotlin
FavoritesScreen(
    favoriteMovies = emptyList(),  // Empty list
    onDiscoverClick = { }
)
```

**With Movies:**

```kotlin
FavoritesScreen(
    favoriteMovies = MovieDataSource.sampleMovies,  // Sample data
    onDiscoverClick = { }
)
```

## 🎨 Customization Guide

### Change Colors

Edit `ui/theme/Color.kt`:

```kotlin
val DarkBackground = Color(0xFF1A1D29)  // Main background
val AccentPurple = Color(0xFFAB47BC)    // Buttons, accents
```

### Modify Empty State Text

Edit `ui/components/EmptyFavoritesState.kt`:

```kotlin
Text(
    text = "No favorites yet",  // Change this
    // ...
)
```

### Adjust Grid Columns

Edit `FavoritesScreen.kt`:

```kotlin
LazyVerticalGrid(
    columns = GridCells.Fixed(2),  // Change to 3 or 4
    // ...
)
```

## 📝 Next Development Steps

### 1. Add Real Favorites Logic

```kotlin
// Create a ViewModel
class FavoritesViewModel : ViewModel() {
    private val _favorites = mutableStateListOf<Movie>()
    val favorites: List<Movie> = _favorites

    fun toggleFavorite(movie: Movie) {
        if (_favorites.contains(movie)) {
            _favorites.remove(movie)
        } else {
            _favorites.add(movie)
        }
    }
}
```

### 2. Add Image Loading (Coil)

In `build.gradle.kts`:

```kotlin
implementation("io.coil-kt:coil-compose:2.5.0")
```

In `MovieCard.kt`:

```kotlin
AsyncImage(
    model = movie.posterUrl,
    contentDescription = movie.title,
    modifier = Modifier.fillMaxSize()
)
```

### 3. Connect to API

```kotlin
// Use Retrofit or similar
interface MovieApi {
    @GET("movies")
    suspend fun getMovies(): List<Movie>
}
```

## 🐛 Troubleshooting

### Build Errors

```bash
# Clean and rebuild
./gradlew clean
./gradlew build
```

### Icons Not Showing

- Make sure `material-icons-extended` dependency is in `build.gradle.kts`
- Sync Gradle files

### Preview Not Working

- Click "Build & Refresh" in the preview pane
- Make sure you're in "Design" or "Split" view
- Rebuild project if needed

## 📚 File Structure Quick Reference

```
app/src/main/java/com/example/movies_shahd/
│
├── MainActivity.kt           - App entry point
├── MovieBoxApp.kt           - Main navigation
│
├── data/
│   └── Movie.kt             - Data model
│
├── ui/
│   ├── components/          - Reusable components
│   │   ├── BottomNavigationBar.kt
│   │   ├── EmptyFavoritesState.kt
│   │   └── MovieCard.kt
│   │
│   ├── screens/             - App screens
│   │   ├── FavoritesScreen.kt  ⭐ FOCUS HERE
│   │   ├── HomeScreen.kt
│   │   ├── ProfileScreen.kt
│   │   └── SearchScreen.kt
│   │
│   ├── previews/            - Preview composables
│   │   └── Previews.kt
│   │
│   └── theme/               - Theming
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
```

## ✨ Key Highlights

### Clean Architecture ✅

- Each component in its own file
- Clear separation of concerns
- Easy to test and maintain

### Reusable Components ✅

- MovieCard can be used anywhere
- EmptyState is a standalone component
- Navigation bar is self-contained

### Modern Design ✅

- Material Design 3
- Dark theme
- Proper spacing and typography
- Smooth animations (built-in)

### Ready for Expansion ✅

- Easy to add new screens
- Simple to integrate API data
- ViewModels can be added easily

## 🎓 Learning Resources

### Jetpack Compose

- [Official Documentation](https://developer.android.com/jetpack/compose)
- [Compose Pathway](https://developer.android.com/courses/pathways/compose)

### Material Design 3

- [Material Design 3](https://m3.material.io/)
- [Compose Material 3](https://developer.android.com/jetpack/compose/designsystems/material3)

## 💡 Tips

1. **Use Previews**: They're faster than running the full app
2. **Component First**: Build and test components individually
3. **State Management**: Keep state at the lowest level possible
4. **Reusability**: Think about how components can be reused
5. **Naming**: Use clear, descriptive names for everything

---

## 🎉 You're Ready!

Your Favorites Screen is fully implemented and ready to present. The component-based architecture makes it easy to:

- Understand the code
- Make modifications
- Add new features
- Test individual parts

**Focus Area**: The `FavoritesScreen.kt` showcases modern Android development with Compose! 🚀
