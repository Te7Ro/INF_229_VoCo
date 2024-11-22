package com.example.kinopoisk.model

import android.provider.Contacts.Photos
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R

@Composable
fun threeofakind(){
    Column (){
        Row (){
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .width(146.dp)
                    .height(82.dp),
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
                    .width(146.dp)
                    .height(82.dp),
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
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .width(308.dp)
                .height(173.dp),
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

@Composable
fun photos() {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        threeofakind()
        Spacer(modifier = Modifier.height(8.dp))
        threeofakind()
        Spacer(modifier = Modifier.height(8.dp))
        threeofakind()
        Spacer(modifier = Modifier.height(8.dp))
        threeofakind()
    }
}