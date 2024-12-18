package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.kinopoisk.R
import com.example.kinopoisk.data.BottomNavigationItems
import com.example.kinopoisk.data.MovieCollection

@ExperimentalCoilApi
@Composable
fun SpisokViewGrid(
    movie: MovieCollection,
    navController: NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("filmPage/${movie.kinopoiskId}") }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(5.dp))
                        .aspectRatio(0.71f),
                    painter = rememberImagePainter(
                        data = movie.posterUrlPreview,
                        builder = {
                            error(R.drawable.img)
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = movie.ratingKinopoisk.toString(),
                    fontSize = 6.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color(0xFF3D3BFF), shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp),
                    color = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                text = movie.nameRu,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = movie.genres.getOrNull(0)?.genre ?: "Жанр",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            )
        }
    }
}