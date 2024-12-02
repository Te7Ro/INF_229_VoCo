package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.MovieCollection
import com.example.kinopoisk.R

@Composable
fun StoryView(movies : List<MovieCollection>, navController: NavHostController){
    val items = remember { movies.toMutableStateList() }
    LazyRow (
        Modifier.fillMaxWidth().height(190.dp)
    ){
        items(items)
        {
            item -> SpisokView(movie = item, navController)
        }
        item {
            Column (
                modifier = Modifier.width(111.dp).fillMaxHeight()
                    .clickable {
                        items.clear()
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.trash_icon),
                    contentDescription = null
                )
                Text(
                    text = "Очистить\nисторию",
                    fontSize = 12.sp,

                )
            }
        }
    }
}