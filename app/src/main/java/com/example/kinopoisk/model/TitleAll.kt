package com.example.kinopoisk.model

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kinopoisk.data.BottomNavigationItems
import com.example.kinopoisk.data.Collection

@Composable
fun TitleAll(type: String, navController: NavHostController){
    var title = ""
    when(type){
        "TOP_POPULAR_ALL" -> title = "Популярное"
        "TOP_POPULAR_MOVIES" -> title = "Популярные фильмы"
        "TOP_250_TV_SHOWS" -> title = "Популярные сериалы"
    }
    Row (modifier = Modifier.fillMaxWidth()
        .padding(vertical = 12.dp)
        .padding(end = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        )
    {
        Text(
            text = title,
            fontSize = 18.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
        )

        )
        Text(
            modifier = Modifier.clickable {
                navController.navigate("collectionPage/$type")
            },
            text = "Все",
            fontSize = 14.sp,
            color = Color(0xFF3D3BFF)
            )
    }
}
@Composable
fun TitleNum(title: String){
    Row (modifier = Modifier.fillMaxWidth()
        .padding(vertical = 12.dp)
        .padding(end = 26.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    )
    {
        Text(
            text = title,
            fontSize = 18.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )

        )
        Text(
            modifier = Modifier.clickable {
            },
            text = "27 >",
            fontSize = 14.sp,
            color = Color(0xFF3D3BFF)
        )
    }
}