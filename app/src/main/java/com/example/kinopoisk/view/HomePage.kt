package com.example.kinopoisk.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.kinopoisk.R

@Composable
fun HomePage() {
    data class MovieItem(val image: Int, val title: String, val genre: String)

    val premierMovies = listOf(
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма")
    )
    val popularMovies = listOf(
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма")
    )
    val actionMoviesUSA = listOf(
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма"),
        MovieItem(R.drawable.movie, "Близкие", "драма")
    )


    @Composable
    fun MovieCard(item: MovieItem) {
        Column {
            Image(painterResource(item.image), contentDescription = null)
            Text(text = item.title)
        }
    }

    @Composable
    fun PremierMoviesSection() {
        LazyRow{
            for (movie in premierMovies){
                item {
                    MovieCard(movie)
                }
            }
        }
    }
    @Composable
    fun PopularMoviesSection() {
        LazyRow {
            for (movie in popularMovies){
                item {
                    MovieCard(movie)
                }
            }
        }
    }

    @Composable
    fun ActionMoviesUSA() {
        LazyRow {
            for (movie in actionMoviesUSA){
                item {
                    MovieCard(movie)
                }
            }
        }
    }

}



