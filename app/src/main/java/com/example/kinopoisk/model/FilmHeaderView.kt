package com.example.kinopoisk.model

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil3.Image
import com.example.kinopoisk.data.FilmHeaderViewModel
import com.example.kinopoisk.data.MovieDetailed

@OptIn(ExperimentalCoilApi::class)
@Composable
fun FilmHeaderView(movie : MovieDetailed) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 0.dp)
            .background(Color.Gray)
            .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            painter = rememberImagePainter(
                data = movie.logoUrl
            ),
            modifier = Modifier.size(159.dp,40.dp),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = movie.ratingKinopoisk.toString() + " " + movie.nameRu,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(2.dp))

        val year = movie.year.toString()
        var genre = ""
        for(items in movie.genres){
            genre += ", "+ items.genre
        }
        Text(
            text = year+genre,
            color = Color.White
        )


        val country = movie.countries.getOrNull(0)?.country ?: ""
        val length = ", "+ (movie.filmLength/60).toString() + " ч " + (movie.filmLength%60).toString() + " мин."
        var age = movie.ratingMpaa
        when(age){
            "g" -> age = ", 0+"
            "pg" -> age = ", 0+"
            "pg-13" -> age = ", 13+"
            "r" -> age = ", 17+"
            "nc-17" -> age = ", 18+"
            else -> age = ""
        }


        Text(
            text = country + length + age,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //for images
        }
    }
}