package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R

@Composable
fun ActorCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .width(49.dp)
                .height(68.dp),
            painter = rememberImagePainter(
                data = "https://kinopoiskapiunofficial.tech/images/actor_posters/kp/10096.jpg",
                builder = {
                    error(R.drawable.img)
                }
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.width(12.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            Text(
                text = "Rober Daun",
            )
            Text(
                text = "Cheloverk Stal' ",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun ActorColumn(){
    Column (modifier = Modifier.padding(bottom = 8.dp)){
    ActorCard()
    ActorCard()
    ActorCard()
    ActorCard()
}}

@Composable
fun ActorRow(){
    LazyRow(Modifier
        .padding(horizontal = 8.dp)
    ) {
        item(){
            ActorColumn()
        }
        item(){
            ActorColumn()
        }
        item(){
            ActorColumn()
        }
        item(){
            ActorColumn()
        }
        item(){
            ActorColumn()
        }
        item(){
            ActorColumn()
        }
    }
}