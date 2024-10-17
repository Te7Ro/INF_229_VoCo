package com.example.kinopoisk.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.kinopoisk.data.BottomNavigationItems
import com.example.kinopoisk.model.BottomNavigationBar
import com.example.kinopoisk.data.BottomNavGraph

@Composable
fun HomePage() {
}

data class MovieItem(val image: Int, val title: String, val genre: String)

val premierMovies = listOf(
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
)
val popularMovies = listOf(
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
)
val actionMoviesUSA = listOf(
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
    MovieItem(R.drawable.movie, "Близкие", "драма")
)
