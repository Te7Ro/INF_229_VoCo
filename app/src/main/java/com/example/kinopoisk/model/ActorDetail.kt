@file:OptIn(ExperimentalCoilApi::class)

package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R
import com.example.kinopoisk.data.ActorDetailed
import com.example.kinopoisk.ui.theme.Grey

@Composable
fun ActorDetail(
    actor: ActorDetailed,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(45.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.clickable { navController.popBackStack() }
                        .size(14.dp),
                    painter = painterResource(R.drawable.icon_back),
                    contentDescription = "Back"
                )
            }
        }
        item {
            Row {
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .width(150.dp)
                        .height(190.dp),
                    painter = rememberImagePainter(
                        data = actor.posterUrl,
                        builder = {
                            error(R.drawable.img)
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(
                        text = actor.nameRu,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 3.dp)
                    )
                    Text(
                        text = actor.profession,
                        fontSize = 14.sp,
                        color = Grey,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(vertical = 6.dp)
                    )
                }
            }
        }

        item {
            Row (modifier = Modifier.fillMaxWidth()
                .padding(vertical = 12.dp)
                .padding(end = 26.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    text = "Фильмография",
                    fontSize = 20.sp,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )

                )
                Text(
                    modifier = Modifier.clickable {
                        navController.navigate("actorFilmography/{${actor.personId}")
                    },
                    text = "К списку   >",
                    fontSize = 18.sp,
                    color = Color(0xFF3D3BFF)
                )
            }
            Text(
                text = "${actor.films.size} фильма",
                fontSize = 14.sp,
                color = Grey
            )
        }
    }
}
