package com.example.kinopoisk.model

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.BottomNavigationItems
import com.example.kinopoisk.R
import com.example.kinopoisk.data.Movie

@Composable
fun ListPage(navController: NavHostController, movies: List<Movie>, type: String){
    val title = when (type) {
        "TOP_POPULAR_ALL" -> "Популярное"
        "TOP_POPULAR_MOVIES" -> "Популярные фильмы"
        "TOP_250_TV_SHOWS" -> "Популярные сериалы"
        else -> ""
    }
    Column {
        Header(title, navController)
        ShowFilmGrid(movies, navController)
    }
}

@Composable
fun Header(title: String, navController: NavHostController){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            modifier = Modifier.clickable { navController.navigate(BottomNavigationItems.Home.route) }
                .size(14.dp),
            painter = painterResource(R.drawable.icon_back),
            contentDescription = ""
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(24.dp))
    }
}