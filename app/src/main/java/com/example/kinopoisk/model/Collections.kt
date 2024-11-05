package com.example.kinopoisk.model

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kinopoisk.data.Collection
import com.example.kinopoisk.data.Movie

@Composable
fun Collections(type: String, collection: Collection)
{
    var title = ""
    when(type){
        "TOP_POPULAR_ALL" -> title = "Популярное"
        "ZOMBIE_THEME" -> title = "Зомби"
        "FAMILY" -> title = "Семейное"
    }
    TitleAll(title)
    ShowFilm(collection.items)
}
@Composable
fun ShowFilm(movies : List<Movie>)
{
    LazyRow(modifier = Modifier.padding(bottom = 20.dp)){
        items(movies)
        {
            movie -> SpisokView(movie = movie)
        }
    }
}

/*
TOP_POPULAR_ALL

ZOMBIE_THEME

FAMILY
 */