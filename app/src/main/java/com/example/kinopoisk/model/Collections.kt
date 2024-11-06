package com.example.kinopoisk.model

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.Collection
import com.example.kinopoisk.data.Movie

@Composable
fun Collections(type: String, collection: Collection, navController: NavHostController)
{
    TitleAll(type, navController)
    ShowFilm(collection.items, navController)
}
@Composable
fun ShowFilm(movies : List<Movie>, navController: NavHostController)
{
    LazyRow(modifier = Modifier.padding(bottom = 20.dp)){
        items(movies)
        {
            movie -> SpisokView(movie = movie, navController)
        }
    }
}