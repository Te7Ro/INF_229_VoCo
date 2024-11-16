@file:OptIn(ExperimentalCoilApi::class, ExperimentalCoilApi::class)

package com.example.kinopoisk.model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.kinopoisk.data.Collection
import com.example.kinopoisk.data.MovieCollection

@Composable
fun Collections(type: String, collection: Collection, navController: NavHostController)
{
    TitleAll(type, navController)
    ShowFilm(collection.items, navController)
}


@Composable
fun ShowFilm(movies : List<MovieCollection>, navController: NavHostController)
{
    LazyRow(modifier = Modifier.padding(bottom = 20.dp)){
        items(movies)
        {
            movie -> SpisokView(movie = movie, navController)
        }
    }
}

@Composable
fun ShowFilmGrid(movies: List<MovieCollection>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(movies) { movie ->
            SpisokViewGrid(movie = movie, navController)
        }
    }
}
