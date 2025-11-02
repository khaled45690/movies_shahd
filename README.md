# MovieBox - Android Compose App

A modern movie browsing application built with Jetpack Compose, featuring a clean architecture and reusable components.

## Project Structure

### 📁 Package Organization

```
com.example.movies_shahd/
├── data/
│   └── Movie.kt                    # Data models and sample data
├── ui/
│   ├── components/                 # Reusable UI components
│   │   ├── BottomNavigationBar.kt  # Bottom navigation bar component
│   │   ├── EmptyFavoritesState.kt  # Empty state for favorites screen
│   │   └── MovieCard.kt            # Movie card component
│   ├── screens/                    # Screen composables
│   │   ├── FavoritesScreen.kt      # Favorites screen (Main focus)
│   │   ├── HomeScreen.kt           # Home screen with movie grid
│   │   ├── ProfileScreen.kt        # Profile screen (placeholder)
│   │   └── SearchScreen.kt         # Search screen (placeholder)
│   └── theme/                      # Theme configuration
│       ├── Color.kt                # Color definitions
│       ├── Theme.kt                # Theme setup
│       └── Type.kt                 # Typography
├── MainActivity.kt                 # Entry point
└── MovieBoxApp.kt                  # Main app composable with navigation
```

## 🎨 Design Features

### Color Scheme

- **Dark Background**: `#1A1D29` - Main app background
- **Dark Surface**: `#252836` - Cards and elevated surfaces
- **Accent Purple**: `#AB47BC` - Primary accent color
- **Accent Pink**: `#EC407A` - Secondary accent color
- **Rating Yellow**: `#FFC107` - Star ratings
- **Text Primary**: White - Main text
- **Text Secondary**: `#92929D` - Secondary text

### Components

#### 1. **MovieCard** (`MovieCard.kt`)

A reusable card component that displays:

- Movie poster (placeholder for now, ready for image loading)
- Movie title (truncated to 1 line)
- Star rating with yellow icon
- Release year

**Usage:**

```kotlin
MovieCard(
    movie = movie,
    onMovieClick = { /* Handle click */ },
    onFavoriteClick = { /* Handle favorite */ }
)
```

#### 2. **BottomNavigationBar** (`BottomNavigationBar.kt`)

A navigation bar with 4 tabs:

- Home (🏠)
- Search (🔍)
- Favorites (❤️)
- Profile (👤)

**Features:**

- Active state highlighting with purple accent
- Smooth transitions between screens

**Usage:**

```kotlin
BottomNavigationBar(
    selectedItem = currentItem,
    onItemSelected = { item -> /* Handle navigation */ }
)
```

#### 3. **EmptyFavoritesState** (`EmptyFavoritesState.kt`)

Empty state component for the favorites screen:

- Heart icon in a circular background
- "No favorites yet" title
- Descriptive text
- "Discover Movies" button

**Usage:**

```kotlin
EmptyFavoritesState(
    onDiscoverClick = { /* Navigate to home */ }
)
```

### Screens

#### **FavoritesScreen** (Main Focus) 📱

The favorites screen is the primary deliverable and includes:

**Features:**

1. **Top App Bar**

   - "My Favorites" title
   - Back button navigation

2. **Empty State**

   - Shown when no favorites exist
   - Centered heart icon with descriptive text
   - "Discover Movies" button to navigate to home

3. **Movies Grid**
   - 2-column grid layout
   - Displays favorite movies using MovieCard component
   - Responsive spacing (12dp horizontal, 16dp vertical)

**Code Location:** `ui/screens/FavoritesScreen.kt`

#### **HomeScreen** (Reference Implementation) 🏠

Reference screen showing how components work together:

- App logo and title in top bar
- Search icon
- 2-column grid of movies
- Uses sample data from `MovieDataSource`

**Code Location:** `ui/screens/HomeScreen.kt`

#### **SearchScreen** & **ProfileScreen**

Placeholder screens with basic layout (ready for future implementation)

## 🔧 Setup & Configuration

### Dependencies

The project uses:

- Jetpack Compose
- Material3
- Kotlin

### Theme Configuration

The app uses a custom dark theme defined in `Theme.kt`:

- Always uses dark mode
- Disables dynamic colors for consistent branding
- Custom color scheme matching the design

## 📝 Key Implementation Details

### Navigation

Navigation is handled in `MovieBoxApp.kt` using state management:

```kotlin
var selectedItem by remember { mutableStateOf(NavigationItem.HOME) }
```

When a navigation item is selected, the corresponding screen is displayed using a `when` statement.

### Data Model

```kotlin
data class Movie(
    val id: Int,
    val title: String,
    val posterUrl: String,
    val rating: Float,
    val year: Int,
    val isFavorite: Boolean = false
)
```

### Sample Data

Located in `data/Movie.kt`:

- 6 sample movies (Harry Potter series, Marvel movies)
- Ready to be replaced with real API data

## 🚀 Next Steps

### To Complete the App:

1. **Add Image Loading**

   - Integrate Coil library for loading movie posters
   - Update `MovieCard.kt` to use AsyncImage

2. **Implement Favorites Logic**

   - Add state management (ViewModel)
   - Implement add/remove favorites functionality
   - Persist favorites using Room or DataStore

3. **Connect to API**

   - Integrate TMDB or similar movie API
   - Replace sample data with real movie data

4. **Complete Search Screen**

   - Add search bar
   - Implement search functionality
   - Display search results

5. **Complete Profile Screen**
   - Add user information
   - Settings and preferences
   - Theme toggle (if needed)

## 📱 Build Instructions

1. Open project in Android Studio
2. Sync Gradle files
3. Run on emulator or physical device (API 26+)

## 🎯 Design Principles

1. **Separation of Concerns**: Components, screens, and data are clearly separated
2. **Reusability**: All UI components are designed to be reusable
3. **Clean Code**: Each file has a single responsibility
4. **Composable First**: Built entirely with Jetpack Compose
5. **Material Design 3**: Follows Material Design 3 guidelines

## 📄 Files Created

### Core Files

- `MainActivity.kt` - App entry point
- `MovieBoxApp.kt` - Main app with navigation

### Data

- `data/Movie.kt` - Movie model and sample data

### UI Components

- `ui/components/BottomNavigationBar.kt`
- `ui/components/EmptyFavoritesState.kt`
- `ui/components/MovieCard.kt`

### Screens

- `ui/screens/FavoritesScreen.kt` ⭐ (Main focus)
- `ui/screens/HomeScreen.kt` (Reference)
- `ui/screens/SearchScreen.kt` (Placeholder)
- `ui/screens/ProfileScreen.kt` (Placeholder)

### Theme

- `ui/theme/Color.kt` - Updated with custom colors
- `ui/theme/Theme.kt` - Updated with dark theme

## 💡 Tips for Development

1. **Preview Components**: Each component can be previewed in Android Studio using `@Preview`
2. **Customize**: All colors are centralized in `Color.kt`
3. **Extend**: Add new screens by creating files in `ui/screens/`
4. **State Management**: Consider adding ViewModels for complex state

---

**Focus**: The FavoritesScreen is the main deliverable, showcasing:

- Clean component architecture
- Empty state handling
- Reusable components
- Material Design 3 implementation
- Professional UI matching the design mockups
