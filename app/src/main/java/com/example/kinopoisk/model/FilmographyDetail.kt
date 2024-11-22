@file:OptIn(ExperimentalCoilApi::class)

package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R
import com.example.kinopoisk.data.ActorDetailed
import com.example.kinopoisk.data.MovieDetailed

@Composable
fun FilmographyDetail(
    films: List<MovieDetailed>,
    navController: NavController,
    actor: ActorDetailed
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    modifier = Modifier.clickable { navController.popBackStack() }
                        .size(14.dp),
                    painter = painterResource(R.drawable.icon_back),
                    contentDescription = "Back"
                )
                Text(
                    text = "Фильмография",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
            Text(
                text = actor.nameRu,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        items(films) { film ->
            FilmRow2(
                film = film,
                onFilmClick = { navController.navigate("filmDetail/${film.kinopoiskId}") }
            )
        }
    }
}

@Composable
fun FilmRow2(
    film: MovieDetailed,
    onFilmClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onFilmClick)
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(100.dp)
                    .height(130.dp),
                painter = rememberImagePainter(
                    data = film.posterUrlPreview,
                    builder = {
                        error(R.drawable.img)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = film.ratingKinopoisk.toString(),
                fontSize = 8.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(4.dp)
                    .background(Color(0xFF3D3BFF), shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp),
                color = Color.White
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = film.nameRu,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "${film.year}",
                style = MaterialTheme.typography.bodyMedium
            )
            if (film.genres.isNotEmpty()) {
                Text(
                    text = film.genres.joinToString(", ") { it.genre },
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }
}