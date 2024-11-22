package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R

@Composable
fun GaleryView() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        item {
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(192.dp)
                    .height(108.dp),
                painter = rememberImagePainter(
                    data = "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/10096.jpg",
                    builder = {
                        error(R.drawable.img)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(192.dp)
                    .height(108.dp),
                painter = rememberImagePainter(
                    data = "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/10096.jpg",
                    builder = {
                        error(R.drawable.img)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(192.dp)
                    .height(108.dp),
                painter = rememberImagePainter(
                    data = "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/10096.jpg",
                    builder = {
                        error(R.drawable.img)
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}